package com.zc.interfacecallback.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zc.interfacecallback.R;
import com.zc.interfacecallback.callback.DataCallBack;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zc on 2018/9/8.
 */

public class MyAdapter extends RecyclerView.Adapter {
    private List<Integer> mData;
    private DataCallBack dataCallBack;

    public MyAdapter(List<Integer> mData, DataCallBack dataCallBack) {
        this.mData = mData;
        this.dataCallBack = dataCallBack;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_rv, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;
        itemHolder.tvContent.setText("item-" + mData.get(position));
        itemHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataCallBack.dataCallBack(itemHolder.tvContent.getText().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_content)
        TextView tvContent;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
