package com.terry.watch.http;

import com.terry.watch.Constant;
import com.terry.watch.entitiy.DistributionResponse;
import com.terry.watch.entitiy.ExchangeDetail;
import com.terry.watch.entitiy.FllowReponse;
import com.terry.watch.entitiy.PositionResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface HttpService {

    @GET(Constant.FOLLOW)
    Observable<FllowReponse> getFllowList();

    @GET
    Observable<PositionResponse> getPositionList(@Url String url);

    @GET
    Observable<ExchangeDetail> getChangeDetail(@Url String url);

    @GET
    Observable<DistributionResponse> getDistribution(@Url String url);
}