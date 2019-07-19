package com.terry.watch.http;

import com.terry.watch.BuildConfig;
import com.terry.watch.Constant;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * OkHttp请求
 *
 * @author 张全
 */
public final class RestClient {
    public static final int TIMEOUT_CONNECTION = 10; //连接超时
    public static final int TIMEOUT_READ = 20; //读取超时
    public static final int TIMEOUT_WRITE = 10; //写入超时

    private static final Charset UTF8 = Charset.forName("UTF-8");
    public static final String REST_API_URL = Constant.HOST;
    private static Retrofit s_retrofit;

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
                .addInterceptor(new HeaderIntercepter());

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        getUnsafeOkHttpClient(builder);
        OkHttpClient client = builder.build();

        s_retrofit = new Retrofit.Builder()
                .baseUrl(REST_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }


    public static void getUnsafeOkHttpClient(OkHttpClient.Builder builder) {
        try {
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            final javax.net.ssl.SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            builder.sslSocketFactory(sslSocketFactory);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    static class HeaderIntercepter implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            String token = UserClient.getToken();
            String deviceId = UserClient.getDeviceId();
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
//            HEYUEDI-APP-TOKEN	c08ceafb6e1061d0fd1f0b7830db527c
//            HEYUEDI-DEVICE-ID	9c799da76468427fab757751b275e72f
            builder.addHeader("HEYUEDI-APP-TOKEN", token);
            builder.addHeader("HEYUEDI-DEVICE-ID", deviceId);
            request = builder.build();
            Response response = chain.proceed(request);
            checkResponse(response);
            return response;
        }
    }


    private static void checkResponse(Response response) {
        try {
            ResponseBody body = response.body();
            BufferedSource source = body.source();
            Headers headers = response.headers();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            if ("gzip".equalsIgnoreCase(headers.get("Content-Encoding"))) {
                GzipSource gzippedResponseBody = null;
                try {
                    gzippedResponseBody = new GzipSource(buffer.clone());
                    buffer = new Buffer();
                    buffer.writeAll(gzippedResponseBody);
                } finally {
                    if (gzippedResponseBody != null) {
                        gzippedResponseBody.close();
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public static <T> T getService(Class<T> serviceClass) {
        return s_retrofit.create(serviceClass);
    }

    public static OkHttpClient getHttpClient() {
        Call.Factory factory = s_retrofit.callFactory();
        return (OkHttpClient) factory;
    }


}
