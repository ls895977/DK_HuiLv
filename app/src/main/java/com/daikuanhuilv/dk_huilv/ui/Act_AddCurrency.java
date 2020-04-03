package com.daikuanhuilv.dk_huilv.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.commt.BaseAct;
import com.daikuanhuilv.dk_huilv.ui.adapter.SortAdapter;
import com.daikuanhuilv.dk_huilv.ui.bean.ActionpublicCurrencyBean;
import com.daikuanhuilv.dk_huilv.ui.bean.User;
import com.daikuanhuilv.dk_huilv.ui.bean.publicCurrencyBean;
import com.daikuanhuilv.dk_huilv.ui.http.ApiConstant;
import com.daikuanhuilv.dk_huilv.ui.view.SideBar;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.lykj.aextreme.afinal.utils.ACache;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 添加货币
 */
public class Act_AddCurrency extends BaseAct {
    @BindView(R.id.listView)
    ListView listView;
    @BindView(R.id.side_bar)
    SideBar sideBar;
    EditText etInput;
    private ACache aCache;

    @Override
    public int initLayoutId() {
        return R.layout.act_addcurrency;
    }

    private ArrayList<User> list = new ArrayList<>();
    private Gson gson;
    ActionpublicCurrencyBean databean;
    View haderView;
    LinearLayout ll_add;

    @Override
    public void initView() {
        hideHeader();
        gson = new Gson();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        ImmersionBar.with(Act_AddCurrency.this)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .init();
        aCache = ACache.get(this);
        haderView = LayoutInflater.from(this).inflate(R.layout.hd_layout, null);
        etInput = getView(haderView, R.id.et_input);
        ll_add = getView(haderView, R.id.ll_add);
        if (aCache.getAsString("databean") != null) {
            databean = gson.fromJson(aCache.getAsString("databean"), ActionpublicCurrencyBean.class);
            for (int i = 0; i < databean.getData().getData().size(); i++) {
                View llAdd = LayoutInflater.from(this).inflate(R.layout.item, null);
                TextView catalog = getView(llAdd, R.id.catalog);
                TextView name = getView(llAdd, R.id.name);
                TextView tv_huobi = getView(llAdd, R.id.tv_huobi);
                ImageView imlier = getView(llAdd, R.id.imlier);
                if (i == 0) {
                    catalog.setText("常用货币");
                    catalog.setVisibility(View.VISIBLE);
                    imlier.setVisibility(View.VISIBLE);
                } else {
                    imlier.setVisibility(View.VISIBLE);
                    catalog.setVisibility(View.GONE);
                }
                name.setText(databean.getData().getData().get(i).getName());
                tv_huobi.setText(databean.getData().getData().get(i).getCurrency());
                ll_add.addView(llAdd);
            }
        }
        listView.addHeaderView(haderView);
        sideBar.setOnStrSelectCallBack(new SideBar.ISideBarSelectCallBack() {
            @Override
            public void onSelectStr(int index, String selectStr) {
                for (int i = 0; i < list.size(); i++) {
                    if (selectStr.equalsIgnoreCase(list.get(i).getFirstLetter())) {
                        listView.setSelection(i); // 选择到首字母出现的位置
                        return;
                    }
                }
            }
        });
    }

    @Override
    public void initData() {
        etInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                list.clear();
                if (etInput.getText().toString().length() > 0) {
                    for (int i = 0; i < bean.getData().getData().size(); i++) {
                        if (bean.getData().getData().get(i).getName().contains(etInput.getText().toString())) {
                            list.add(new User(bean.getData().getData().get(i).getName(), bean.getData().getData().get(i).getCurrency()));  // 亳[bó]属于不常见的二级汉字
                        }
                    }
                    Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
                } else {
                    for (int i = 0; i < bean.getData().getData().size(); i++) {
                        list.add(new User(bean.getData().getData().get(i).getName(), bean.getData().getData().get(i).getCurrency())); // 亳[bó]属于不常见的二级汉字
                    }
                    Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
                }
                adapter.notifyDataSetChanged();
            }
        });
        adapter = new SortAdapter(Act_AddCurrency.this, list);
        adapter.setBackItem(new SortAdapter.backItem() {
            @Override
            public void baItem(User user) {
                if (aCache.getAsString("databean") != null) {
                    ActionpublicCurrencyBean actionpublicCurrencyBean = gson.fromJson(aCache.getAsString("databean"), ActionpublicCurrencyBean.class);
                    ActionpublicCurrencyBean.DataBeanX.DataBean bean1 = new ActionpublicCurrencyBean.DataBeanX.DataBean();
                    boolean ActionpublicCurrencyStatus = true;
                    for (int i = 0; i < actionpublicCurrencyBean.getData().getData().size(); i++) {
                        if (actionpublicCurrencyBean.getData().getData().get(i).getName().equals(user.getName())) {
                            ActionpublicCurrencyStatus = false;
                            break;
                        } else {
                            ActionpublicCurrencyStatus = true;
                        }
                    }
                    if (ActionpublicCurrencyStatus) {
                        bean1.setName(user.getName());
                        bean1.setCurrency(user.getCurrency());
                        actionpublicCurrencyBean.getData().getData().add(bean1);
                    } else {
                        MyToast.show(getApplicationContext(), "您选择的国家已添加！");
                        return;
                    }
                    String data = gson.toJson(actionpublicCurrencyBean);
                    aCache.put("databean", data);
                } else {
                    ActionpublicCurrencyBean bean = new ActionpublicCurrencyBean();
                    ActionpublicCurrencyBean.DataBeanX dataBeanX = new ActionpublicCurrencyBean.DataBeanX();
                    List<ActionpublicCurrencyBean.DataBeanX.DataBean> DataBean = new ArrayList<>();
                    ActionpublicCurrencyBean.DataBeanX.DataBean bean1 = new ActionpublicCurrencyBean.DataBeanX.DataBean();
                    bean1.setName(user.getName());
                    bean1.setCurrency(user.getCurrency());
                    DataBean.add(bean1);
                    dataBeanX.setData(DataBean);
                    bean.setData(dataBeanX);
                    String dataMessage = gson.toJson(bean);
                    aCache.put("databean", dataMessage);
                }
                setResult(10);
                finish();
            }
        });
        listView.setAdapter(adapter);
        if (aCache.getAsString("ActionSlider") != null) {
            String data = aCache.getAsString("ActionSlider");//这个就是返回来的结果
            bean = gson.fromJson(data, publicCurrencyBean.class);
            if (bean.getStatus() == 1) {
                aCache.put("ActionSlider", data);
                for (int i = 0; i < bean.getData().getData().size(); i++) {
                    User user = new User(bean.getData().getData().get(i).getName(), bean.getData().getData().get(i).getCurrency());
                    if (databean != null) {
                        for (int j = 0; j < databean.getData().getData().size(); j++) {
                            if (databean.getData().getData().get(j).getCurrency().equals(bean.getData().getData().get(i).getCurrency())) {
                                user.setChoseStatus(true);
                            }
                        }
                    }
                    list.add(user); // 亳[bó]属于不常见的二级汉字
                }
                Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
            }
        } else {
            ActionSlider();
        }
    }

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

    @OnClick(R.id.bt_Bookkeeping)
    public void onViewClicked() {
        finish();
    }
    publicCurrencyBean bean;
    SortAdapter adapter;
    /**
     * 单个货币的所有汇率
     */
    public void ActionSlider() {
        loding.show();
        OkGo.<String>get(ApiConstant.ROOT_URL + ApiConstant.publicCurrency)
                .tag(this)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        loding.dismiss();
                        String data = response.body();//这个就是返回来的结果
                        Gson gson = new Gson();
                        bean = gson.fromJson(data, publicCurrencyBean.class);
                        if (bean.getStatus() == 1) {
                            aCache.put("ActionSlider", data);
                            for (int i = 0; i < bean.getData().getData().size(); i++) {
                                User user = new User(bean.getData().getData().get(i).getName(), bean.getData().getData().get(i).getCurrency());
                                if (databean != null) {
                                    for (int j = 0; j < databean.getData().getData().size(); j++) {
                                        if (databean.getData().getData().get(j).getCurrency().equals(bean.getData().getData().get(i).getCurrency())) {
                                            user.setChoseStatus(true);
                                        }
                                    }
                                }
                                list.add(user); // 亳[bó]属于不常见的二级汉字
                            }
                            Collections.sort(list); // 对list进行排序，需要让User实现Comparable接口重写compareTo方法
                            if (adapter != null) {
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        loding.dismiss();
                        super.onError(response);
                    }
                });
    }
}
