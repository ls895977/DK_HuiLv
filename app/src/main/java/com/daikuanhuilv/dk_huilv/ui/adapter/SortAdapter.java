package com.daikuanhuilv.dk_huilv.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.ui.bean.User;

import java.util.List;

public class SortAdapter extends BaseAdapter {

    private List<User> list = null;
    private Context mContext;
    private backItem backItem;

    public void setBackItem(SortAdapter.backItem backItem) {
        this.backItem = backItem;
    }

    public SortAdapter(Context mContext, List<User> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public int getCount() {
        return this.list.size();
    }

    public Object getItem(int position) {
        return list.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup arg2) {
        ViewHolder viewHolder;
        final User user = list.get(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
            viewHolder.tv_huobi = view.findViewById(R.id.tv_huobi);
            viewHolder.tv_choseStatus = view.findViewById(R.id.tv_choseStatus);
            viewHolder.ll_name = view.findViewById(R.id.ll_name);
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.catalog = (TextView) view.findViewById(R.id.catalog);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //根据position获取首字母作为目录catalog
        String catalog = list.get(position).getFirstLetter();

        //如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
        if (position == getPositionForSection(catalog)) {
            viewHolder.catalog.setVisibility(View.VISIBLE);
            viewHolder.catalog.setText(user.getFirstLetter().toUpperCase());
        } else {
            viewHolder.catalog.setVisibility(View.GONE);
        }
        viewHolder.ll_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (backItem != null) {
                    backItem.baItem(list.get(position));
                }
            }
        });
        if (this.list.get(position).isChoseStatus()) {
            viewHolder.tv_choseStatus.setVisibility(View.VISIBLE);
        } else {
            viewHolder.tv_choseStatus.setVisibility(View.GONE);
        }
        viewHolder.name.setText(this.list.get(position).getName());
        viewHolder.tv_huobi.setText(this.list.get(position).getCurrency());
        return view;
    }
    final static class ViewHolder {
        TextView catalog, tv_huobi, tv_choseStatus;
        RelativeLayout ll_name;
        TextView name;
    }

    /**
     * 获取catalog首次出现位置
     */
    public int getPositionForSection(String catalog) {
        for (int i = 0; i < getCount(); i++) {
            String sortStr = list.get(i).getFirstLetter();
            if (catalog.equalsIgnoreCase(sortStr)) {
                return i;
            }
        }
        return -1;
    }

    public interface backItem {
        void baItem(User user);
    }

}