package com.daikuanhuilv.dk_huilv.ui.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.ui.bean.ActionpublicCurrencyBean;
import com.daikuanhuilv.dk_huilv.ui.bean.currencyBean;
import com.lykj.aextreme.afinal.utils.Debug;

import java.lang.reflect.Field;
import java.util.List;

public class currencyAdapter extends BaseQuickAdapter<ActionpublicCurrencyBean.DataBeanX.DataBean, BaseViewHolder> {
    public currencyAdapter(List<ActionpublicCurrencyBean.DataBeanX.DataBean> data) {
        super(R.layout.item_currency, data);
    }
    private backStatusItem backStatusItem;

    public void setBackStatusItem(currencyAdapter.backStatusItem backStatusItem) {
        this.backStatusItem = backStatusItem;
    }

    @Override
    protected void convert(BaseViewHolder helper, ActionpublicCurrencyBean.DataBeanX.DataBean item) {
        Glide.with(mContext).load(getResourceByReflect(item.getPicture())).into((ImageView) helper.getView(R.id.im_picture));
        RelativeLayout reItem = helper.getView(R.id.re_ll);
        reItem.setSelected(item.isStatus());
        helper.setText(R.id.tv_currency, item.getCurrency())
                .setText(R.id.tv_name, item.getName()+" "+item.getSymbol());
        EditText editText = helper.getView(R.id.et_input);
        if (editText.getTag() instanceof TextWatcher) {
            editText.removeTextChangedListener((TextWatcher) editText.getTag());
        }
        if (item.getMoney() == null || item.getMoney().equals(0.0)) {
            editText.setText("");
        } else {
            java.text.DecimalFormat df = new java.text.DecimalFormat("0.0000");
            editText.setText(df.format(item.getMoney()) + "");
        }
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                reItem.setSelected(true);
                if (editText.getText().toString() == null) {
                    backStatusItem.afterTextChanged("0", helper.getPosition(), item);
                } else {
                    backStatusItem.afterTextChanged(editText.getText().toString(), helper.getPosition(), item);
                }
            }
        };
        editText.addTextChangedListener(watcher);
        editText.setTag(watcher);

    }

    public interface backStatusItem {
        void onFocusChange(View v, boolean hasFocus, int Position);

        void afterTextChanged(String name, int Position, ActionpublicCurrencyBean.DataBeanX.DataBean bean);
    }

    /**
     * 获取图片名称获取图片的资源id的方法
     *
     * @param imageName
     * @return
     */
    public int getResourceByReflect(String imageName) {
        Class drawable = R.drawable.class;
        Field field = null;
        int r_id;
        try {
            field = drawable.getField(imageName);
            r_id = field.getInt(field.getName());
        } catch (Exception e) {
            r_id = R.drawable.icon_lion;
            Log.e("ERROR", "PICTURE NOT　FOUND！");
        }
        return r_id;
    }
}

