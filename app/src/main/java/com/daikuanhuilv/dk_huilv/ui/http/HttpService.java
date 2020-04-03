package com.daikuanhuilv.dk_huilv.ui.http;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;

public interface HttpService {

    @GET(ApiConstant.publicCurrency)
    Observable<String> publicCurrency(@QueryMap Map<String, String> map);

    @GET(ApiConstant.publicSingle)
    Observable<String> publicSingle(@QueryMap Map<String, String> map);

    @GET(ApiConstant.publicConvert)
    Observable<String> publicConvert(@QueryMap Map<String, String> map);
}