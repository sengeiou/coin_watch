package com.terry.watch.viewmodel;


import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.terry.watch.entitiy.DistributionResponse;
import com.terry.watch.entitiy.ExchangeDetail;
import com.terry.watch.entitiy.HomeResponse;
import com.terry.watch.entitiy.PositionResponse;
import com.terry.watch.http.UserClient;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;

/**
 * @author 张全
 */
public class HomeViewModel extends BaseAndroidViewModel {
    public static final String TAG_DISTRIBUTION = "TAG_DISTRIBUTION";
    public static final String TAG_POSITION = "TAG_POSITION";
    public static final String TAG_EXCHANGE="TAG_EXCHANGE";
    public MutableLiveData<NetReqResult> liveData = new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public void getHomeData(String uid,String platform) {
        compositeDisposable.add(Observable.zip(UserClient.getDistribution(uid),
                UserClient.getPositionList(uid,platform), new BiFunction<DistributionResponse, PositionResponse, HomeResponse>() {
                    @Override
                    public HomeResponse apply(DistributionResponse distributionResponse, PositionResponse positionResponse) throws Exception {
                        HomeResponse homeResponse = new HomeResponse();
                        homeResponse.distributionResponse = distributionResponse;
                        homeResponse.positionResponse = positionResponse;
                        return homeResponse;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeResponse>() {
                    @Override
                    public void accept(HomeResponse response) throws Exception {
                        liveData.setValue(new NetReqResult(null, null, true, response));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.setValue(new NetReqResult(null, "请求失败", false));
                    }
                }));

    }
    public void getHomeData(String uid,String platform1,String platform2) {
        compositeDisposable.add(Observable.zip(UserClient.getDistribution(uid),
                UserClient.getPositionList(uid,platform1),
                UserClient.getPositionList(uid,platform2),
                new Function3<DistributionResponse, PositionResponse, PositionResponse,HomeResponse>() {
                    @Override
                    public HomeResponse apply(DistributionResponse distributionResponse, PositionResponse positionResponse,PositionResponse positionResponse2) throws Exception {
                        HomeResponse homeResponse = new HomeResponse();
                        homeResponse.distributionResponse = distributionResponse;
                        homeResponse.positionResponse = positionResponse;
                        homeResponse.positionResponse2 = positionResponse2;
                        return homeResponse;
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeResponse>() {
                    @Override
                    public void accept(HomeResponse response) throws Exception {
                        liveData.setValue(new NetReqResult(null, null, true, response));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.setValue(new NetReqResult(null, "请求失败", false));
                    }
                }));

    }

    public void getExchangeDetail(String id){
        Disposable subscribe = UserClient.getChangeDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ExchangeDetail>() {
                    @Override
                    public void accept(ExchangeDetail exchangeDetail) throws Exception {
                        liveData.setValue(new NetReqResult(TAG_EXCHANGE, null, true, exchangeDetail));
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        liveData.setValue(new NetReqResult(TAG_EXCHANGE, null, false, null));
                    }
                });
    }


}
