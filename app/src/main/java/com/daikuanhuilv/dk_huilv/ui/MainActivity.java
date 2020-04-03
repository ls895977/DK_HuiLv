package com.daikuanhuilv.dk_huilv.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.commt.BaseAct;
import com.daikuanhuilv.dk_huilv.ui.adapter.SortAdapter;
import com.daikuanhuilv.dk_huilv.ui.adapter.currencyAdapter;
import com.daikuanhuilv.dk_huilv.ui.bean.ActionpublicCurrencyBean;
import com.daikuanhuilv.dk_huilv.ui.bean.User;
import com.daikuanhuilv.dk_huilv.ui.bean.currencyBean;
import com.daikuanhuilv.dk_huilv.ui.bean.publicCurrencyBean;
import com.daikuanhuilv.dk_huilv.ui.http.ApiConstant;
import com.daikuanhuilv.dk_huilv.ui.http.HttpHelper;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseAct {
    @BindView(R.id.my_RecyclerView)
    SwipeMenuRecyclerView myRecyclerView;
    //    @BindView(R.id.refreshLayout)
//    SmartRefreshLayout mRefreshLayout;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        hideHeader();
        aCache = ACache.get(this);
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(MainActivity.this)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .init();
        if (aCache.getAsString("status") != null) {

        } else {
            initSvavData();
        }
    }

    public void initSvavData() {
        Gson gson = new Gson();
        ActionpublicCurrencyBean bean = new ActionpublicCurrencyBean();
        ActionpublicCurrencyBean.DataBeanX dataBeanX = new ActionpublicCurrencyBean.DataBeanX();
        List<ActionpublicCurrencyBean.DataBeanX.DataBean> DataBean = new ArrayList<>();
        ActionpublicCurrencyBean.DataBeanX.DataBean rmb = new ActionpublicCurrencyBean.DataBeanX.DataBean();
        rmb.setName("人民币");
        rmb.setCurrency("CNY");
        DataBean.add(rmb);
        ActionpublicCurrencyBean.DataBeanX.DataBean meiyuan = new ActionpublicCurrencyBean.DataBeanX.DataBean();
        meiyuan.setName("美元");
        meiyuan.setCurrency("USD");
        DataBean.add(meiyuan);
        //印尼卢比
        ActionpublicCurrencyBean.DataBeanX.DataBean yingnilvbi = new ActionpublicCurrencyBean.DataBeanX.DataBean();
        yingnilvbi.setName("印尼卢比");
        yingnilvbi.setCurrency("IDR");
        DataBean.add(yingnilvbi);
        dataBeanX.setData(DataBean);
        //印度卢比
        ActionpublicCurrencyBean.DataBeanX.DataBean yingdulvbi = new ActionpublicCurrencyBean.DataBeanX.DataBean();
        yingdulvbi.setName("印度卢比");
        yingdulvbi.setCurrency("INR");
        DataBean.add(yingdulvbi);
        //越南盾
        ActionpublicCurrencyBean.DataBeanX.DataBean yuenandun = new ActionpublicCurrencyBean.DataBeanX.DataBean();
        yuenandun.setName("越南盾");
        yuenandun.setCurrency("VND");
        DataBean.add(yuenandun);
        dataBeanX.setData(DataBean);
        bean.setData(dataBeanX);
        String dataMessage = gson.toJson(bean);
        aCache.put("databean", dataMessage);
        aCache.put("status", "yes");
    }

    private int PositionIndext = 0;
    private int indextPosition = 0;

    @Override
    public void initData() {
        // 创建菜单：
        SwipeMenuCreator mSwipeMenuCreator = (leftMenu, rightMenu, viewType) -> {
            SwipeMenuItem deleteItem = new SwipeMenuItem(context);
            deleteItem
                    .setImage(R.mipmap.icon_delete)
                    .setBackgroundColor(getResources().getColor(R.color.myyeee))
                    .setWidth(dip2px(80))
                    .setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
            rightMenu.addMenuItem(deleteItem);
        };
        // 设置监听器。
        myRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
        // 菜单点击监听。
        myRecyclerView.setSwipeMenuItemClickListener(new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                menuBridge.closeMenu();
                int menuPosition = menuBridge.getAdapterPosition(); // 菜单在RecyclerView的Item中的Position。
                Debug.e("-----------点击了===" + menuPosition);
                if (aCache.getAsString("databean") != null) {
                    Gson gson = new Gson();
                    ActionpublicCurrencyBean actionpublicCurrencyBean = gson.fromJson(aCache.getAsString("databean"), ActionpublicCurrencyBean.class);
                    actionpublicCurrencyBean.getData().getData().remove(menuPosition);
                    data.remove(menuPosition);
                    adapter.notifyDataSetChanged();
                    aCache.put("databean", gson.toJson(actionpublicCurrencyBean));
                }
            }
        });
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        data = new ArrayList<>();
        adapter = new currencyAdapter(data);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                adapter.notifyDataSetChanged();
            }
        });
        myRecyclerView.setAdapter(adapter);
        if (aCache.getAsString("databean") != null && aCache.getAsString("publicSingle") != null) {
            databean();
        } else {
            loding.show();
            start();
        }
    }

    public void databean() {
        data.clear();
        Gson gson = new Gson();
        ActionpublicCurrencyBean actionpublicCurrencyBean = gson.fromJson(aCache.getAsString("databean"), ActionpublicCurrencyBean.class);
        for (int i = 0; i < actionpublicCurrencyBean.getData().getData().size(); i++) {
            ActionpublicCurrencyBean datasBean = gson.fromJson(aCache.getAsString("publicSingle"), ActionpublicCurrencyBean.class);
            data.add(actionpublicCurrencyBean.getData().getData().get(i));
            data.get(i).setMoney(0.0);
            for (int j = 0; j < datasBean.getData().getData().size(); j++) {
                if (data.get(i).getCurrency().equals(datasBean.getData().getData().get(j).getCurrency()) ||
                        data.get(i).getCurrency().equals("CNY")) {
                    if (data.get(i).getCurrency().equals("CNY")) {
                        data.get(i).setPicture("cn");
                        data.get(i).setSymbol("¥");
                    } else {
                        data.get(i).setPicture(datasBean.getData().getData().get(j).getPicture());
                        data.get(i).setSymbol(datasBean.getData().getData().get(j).getSymbol());
                    }
                }
            }
        }
        adapter.setBackStatusItem(new currencyAdapter.backStatusItem() {
            @Override
            public void onFocusChange(View v, boolean hasFocus, int Position) {
                indextPosition = Position;
                for (int i = 0; i < data.size(); i++) {
                    data.get(i).setStatus(false);
                }
                data.get(Position).setStatus(true);
            }

            @Override
            public void afterTextChanged(String name, int Position, ActionpublicCurrencyBean.DataBeanX.DataBean item) {
                java.text.DecimalFormat df = new java.text.DecimalFormat("#.0000");
                if (name.equals("") || name.equals("0") || name.length() == 0) {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setMoney(0.0);
                    }
                    for (int m = 0; m < data.size(); m++) {
                        if (m != Position && m < data.size()) {
//                                Debug.e("--------刷新=为零==" + m);
                            adapter.notifyItemChanged(m);
                        }
                    }
                    return;
                }
                ActionpublicCurrencyBean datasBean = gson.fromJson(aCache.getAsString("publicSingle"), ActionpublicCurrencyBean.class);
                if (item.getCurrency().equals("CNY")) {//如果是人民币输入
                    for (int i = 0; i < data.size(); i++) {
                        for (int j = 0; j < datasBean.getData().getData().size(); j++) {
                            if (datasBean.getData().getData().get(j).getCurrency().equals(item.getCurrency())) {
                            } else {
                                if (data.get(i).getCurrency().equals(datasBean.getData().getData().get(j).getCurrency())) {
                                    double sum = Double.valueOf(name) * Double.valueOf(datasBean.getData().getData().get(j).getRate());
                                    data.get(i).setMoney(sum);
                                }
                            }
                        }
                    }
                } else {//如果是其它币种换其它比重
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).getCurrency().equals(item.getCurrency())) {//本身不参于计算

                        } else if (data.get(i).getCurrency().equals("CNY")) {//人民币不参于计算
                            for (int j = 0; j < datasBean.getData().getData().size(); j++) {
                                if (datasBean.getData().getData().get(j).getCurrency().equals(item.getCurrency())) {
                                    double sum = Double.valueOf(name) / Double.valueOf(datasBean.getData().getData().get(j).getRate());
                                    data.get(i).setMoney(sum);
                                }
                            }
                        } else {//其它参与计算
                            Double rmbRate = 0.0;
                            for (int j = 0; j < datasBean.getData().getData().size(); j++) {//取出当前与人民币的汇率
                                if (datasBean.getData().getData().get(j).getCurrency().equals(item.getCurrency())) {
                                    rmbRate = Double.valueOf(name) / Double.valueOf(datasBean.getData().getData().get(j).getRate());
                                }
                            }
                            for (int j = 0; j < datasBean.getData().getData().size(); j++) {
                                if (datasBean.getData().getData().get(j).getCurrency().equals(data.get(i).getCurrency())) {
                                    double sum = Double.valueOf(rmbRate) * Double.valueOf(datasBean.getData().getData().get(j).getRate());
                                    data.get(i).setMoney(sum);
                                }
                            }
                        }
                    }
                }
                for (int m = 0; m < data.size(); m++) {
                    if (m != Position && m < data.size()) {
                        Debug.e("--------刷新===" + m);
                        adapter.notifyItemChanged(m);
                    }
                }
            }
        });
    }

    private currencyAdapter adapter;
    List<ActionpublicCurrencyBean.DataBeanX.DataBean> data;

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_commit, R.id.bt_commit1,R.id.bt_Bookkeeping})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_commit:
            case R.id.bt_commit1:
                startActivityForResult(Act_AddCurrency.class, 10);
                break;
            case R.id.bt_Bookkeeping:
                startAct(Act_ProblemFeedback.class);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intentdata) {
        super.onActivityResult(requestCode, resultCode, intentdata);
        if (requestCode == 10 && resultCode == 10) {
            data.clear();
            Gson gson = new Gson();
            ActionpublicCurrencyBean actionpublicCurrencyBean = gson.fromJson(aCache.getAsString("databean"), ActionpublicCurrencyBean.class);
            for (int i = 0; i < actionpublicCurrencyBean.getData().getData().size(); i++) {
                ActionpublicCurrencyBean datasBean = gson.fromJson(aCache.getAsString("publicSingle"), ActionpublicCurrencyBean.class);
                data.add(actionpublicCurrencyBean.getData().getData().get(i));
                for (int j = 0; j < datasBean.getData().getData().size(); j++) {
                    if (data.get(i).getCurrency().equals(datasBean.getData().getData().get(j).getCurrency()) ||
                            data.get(i).getCurrency().equals("CNY")) {
                        if (data.get(i).getCurrency().equals("CNY")) {
                            data.get(i).setPicture("cn");
                            data.get(i).setSymbol("¥");
                        } else {
                            data.get(i).setPicture(datasBean.getData().getData().get(j).getPicture());
                            data.get(i).setSymbol(datasBean.getData().getData().get(j).getSymbol());

                        }
                    }
                }
            }
            adapter.notifyDataSetChanged();
        }
    }

    /**
     * 获取所有货币
     */
    public void ActionpublicCurrency() {
        OkGo.<String>get(ApiConstant.ROOT_URL + ApiConstant.publicSingle)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        loding.dismiss();
                        String data = response.body();//这个就是返回来的结果
                        Gson gson = new Gson();
                        ActionpublicCurrencyBean bean = gson.fromJson(data, ActionpublicCurrencyBean.class);
                        if (bean.getStatus() == 1) {
                            if (aCache.getAsString("publicSingle") == null) {
                                aCache.put("publicSingle", data);
                                databean();
                                adapter.notifyDataSetChanged();
                            } else {
                                aCache.put("publicSingle", data);
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        loding.dismiss();
                        if (response.body() == null || response.body().equals("null")) {
                            MyToast.show(getApplicationContext(), "获取超时！");
                        }
                        super.onError(response);
                    }
                });
    }

    /**
     * 高度转换
     *
     * @param dp
     * @return
     */
    public int dip2px(int dp) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    // 计时器
    private Timer timer;
    int i = 0;

    /**
     * @param
     * @return void
     * @throws
     * @Description: 开始计时
     */
    public void start() {
        if (timer == null) {
            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    ActionpublicCurrency();
                    i++;
                }
            }, 0, 30000);
        }
    }
}
