package com.terry.watch.http;

import com.terry.watch.Constant;
import com.terry.watch.entitiy.ExchangeDetail;
import com.terry.watch.entitiy.FllowReponse;
import com.terry.watch.entitiy.PositionResponse;

import io.reactivex.Observable;

/**
 * @author 张全
 */
public class UserClient {

    /**
     * 关注列表
     *
     * @return
     */
    public static Observable<FllowReponse> getFllowList() {
        return RestClient.getService(HttpService.class)
                .getFllowList();
    }

    /**
     * 资产
     *
     * @param uid
     * @return
     */
    public static Observable<PositionResponse> getPositionList(String uid) {
        String url = Constant.HOST + Constant.POSITION + "?uid=" + uid + "&exchange=okex";
        return RestClient.getService(HttpService.class)
                .getPositionList(url);
    }

    /**
     * 交易详情
     *
     * @param id
     * @return
     */
    public static Observable<ExchangeDetail> getChangeDetail(String id) {
        String url = Constant.HOST + Constant.EXCHANGE + "?id=" + id + "&exchange=okex";
        return RestClient.getService(HttpService.class)
                .getChangeDetail(url);
    }


    public static String getToken() {
        return "c08ceafb6e1061d0fd1f0b7830db527c";
    }

    public static void setToken(String token) {

    }

    public static String getDeviceId() {
        return "9c799da76468427fab757751b275e72f";
    }


}
