package com.daikuanhuilv.dk_huilv.ui;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.commt.BaseAct;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 加载页
 */
public class Act_Loding extends BaseAct {
    @Override
    public int initLayoutId() {
        return R.layout.act_loding;
    }

    private ACache aCache;

    @Override
    public void initView() {
        aCache = ACache.get(this);
        updateHandler.sendEmptyMessageDelayed(14, 2000);
    }

    int i = 0;
    private Handler updateHandler = new Handler() {
        @Override
        public void dispatchMessage(Message msg) {
            super.dispatchMessage(msg);
            if (msg.what == 14) {
                startActClear(MainActivity.class);
            }
        }
    };

    @Override
    public void initData() {
        hideHeader();
        ButterKnife.bind(this);
        ImmersionBar.with(this)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .init();
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }
}
