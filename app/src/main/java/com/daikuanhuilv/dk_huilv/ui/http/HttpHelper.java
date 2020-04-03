package com.daikuanhuilv.dk_huilv.ui.http;

import android.content.Context;
import android.content.Intent;
import com.google.gson.Gson;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.Utils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;

public class HttpHelper {
    /**
     * 获取所有货币
     */
    public static void publicCurrency(Context context, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.publicCurrency(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        Debug.e("-------------succeed===" + succeed);
//                        getSmsVerifyBean entity = gson.fromJson(succeed, getSmsVerifyBean.class);
//                        if (choseLoginStatis(entity.getStatus(), context)) {
//                            return;
//                        }
//                        if (entity.getStatus() == 1) {
//                            callBack.onSucceed(succeed);
//                        } else {
//                            callBack.onError("获取失败！");
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Debug.e("-------------onError===" + e.getMessage());
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    /**
     * 单个货币的所有汇率
     * currency （要换算的国家的currency，currency借款的currency字段
     */
    public static void publicSingle(Context context,String currency, final HttpUtilsCallBack<String> callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("currency",currency);
        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
        httpService.publicSingle(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String succeed) {
                        Gson gson = new Gson();
                        Debug.e("-------------succeed===" + succeed);
//                        getSmsVerifyBean entity = gson.fromJson(succeed, getSmsVerifyBean.class);
//                        if (choseLoginStatis(entity.getStatus(), context)) {
//                            return;
//                        }
//                        if (entity.getStatus() == 1) {
//                            callBack.onSucceed(succeed);
//                        } else {
//                            callBack.onError("获取失败！");
//                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFailure(httpFailureMsg());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
    /**
     * 汇率转换
     * from （要换算的国家的currency，currency借款的currency字段
     */
//    public static void publicSingle(Context context,String currency, final HttpUtilsCallBack<String> callBack) {
//        HashMap<String, String> map = new HashMap<>();
//        map.put("currency",currency);
//        HttpService httpService = RetrofitFactory.getRetrofit(15l, 15l).create(HttpService.class);
//        httpService.publicSingle(map)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                    }
//
//                    @Override
//                    public void onNext(String succeed) {
//                        Gson gson = new Gson();
//                        Debug.e("-------------succeed===" + succeed);
////                        getSmsVerifyBean entity = gson.fromJson(succeed, getSmsVerifyBean.class);
////                        if (choseLoginStatis(entity.getStatus(), context)) {
////                            return;
////                        }
////                        if (entity.getStatus() == 1) {
////                            callBack.onSucceed(succeed);
////                        } else {
////                            callBack.onError("获取失败！");
////                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        callBack.onFailure(httpFailureMsg());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                    }
//                });
//    }


    public interface HttpUtilsCallBack<T> {
        public void onFailure(String failure);

        public void onSucceed(T succeed);

        public void onError(String error);
    }

    private static String httpFailureMsg() {
        if (NetUtils.isConnected()) {
//            return "很抱歉，系统繁忙，请稍后重试。";
            return "Silakan Cek Link Internet";
        } else {
//            return "检查网络连接情况，请稍后重试。";
            return "Silakan Cek Link Internet";
        }
    }
}