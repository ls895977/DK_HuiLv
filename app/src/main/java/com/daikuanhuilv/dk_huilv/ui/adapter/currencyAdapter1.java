package com.daikuanhuilv.dk_huilv.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.ui.bean.ActionpublicCurrencyBean;

import java.util.ArrayList;

public class currencyAdapter1 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ActionpublicCurrencyBean.DataBeanX.DataBean> mList;
    private onTextChangeListener mTextListener;

    public currencyAdapter1(Context context, ArrayList<ActionpublicCurrencyBean.DataBeanX.DataBean> list) {
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mList = list;
    }
    //设置自定义接口成员变量
    public void setOnTextChangeListener(onTextChangeListener onTextChangeListener) {
        this.mTextListener = onTextChangeListener;
    }

    //创建ViewHolder
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = new
                itemHolder2(mInflater.inflate(R.layout.item_currency, parent, false));
        return holder;
    }

    //绑定ViewHolder
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int
            position) {
        final itemHolder2 holder2 = (itemHolder2) holder;
        holder2.tv_currency.setText(mList.get(position).getCurrency());
        holder2.tv_name.setText(mList.get(position).getName());
//        EditText editText =  holder.getView(R.id.et_comment);
//        if (mList.get(position).getMoney() == null || mList.get(position).getMoney().equals("")) {
//
//        } else {
//            holder2.input.setText((String) mList.get(position).getMoney());
//        }
        //添加EditText的监听事件
//        holder2.input.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                //通过接口回调将数据传递到Activity中
//                mTextListener.onTextChanged(position, holder2.input.getText().toString(),mList.get(position));
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    //内部类 ViewHolder
    class itemHolder2 extends RecyclerView.ViewHolder {
        TextView tv_currency ,tv_name;
        EditText input;

        public itemHolder2(View itemView) {
            super(itemView);
            tv_currency = (TextView) itemView.findViewById(R.id.tv_currency);
            tv_name=itemView.findViewById(R.id.tv_name);
            input = (EditText) itemView.findViewById(R.id.et_input);
        }
    }

    public interface onTextChangeListener {
        void  onTextChanged(int position,String etName,ActionpublicCurrencyBean.DataBeanX.DataBean item);
    }
}