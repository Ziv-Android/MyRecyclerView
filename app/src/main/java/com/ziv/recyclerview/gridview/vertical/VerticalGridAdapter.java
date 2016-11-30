package com.ziv.recyclerview.gridview.vertical;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ziv.recyclerview.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Horizontal List View Adapter
 * Created by ziv on 16-11-30.
 */
public class VerticalGridAdapter extends RecyclerView.Adapter<VerticalGridAdapter.VerticalGridViewHolder> {
    private Context mContext;
    private List<String> mData;

    public VerticalGridAdapter(Context context, List list) {
        mContext = context;
        mData = list;
    }

    @Override
    public VerticalGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        ButterKnife.bind(this, view);
        VerticalGridViewHolder holder = new VerticalGridViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(VerticalGridViewHolder holder, int position) {
        holder.contextTxt.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class VerticalGridViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_context)
        TextView contextTxt;

        public VerticalGridViewHolder(View itemView) {
            super(itemView);
            contextTxt = (TextView) itemView.findViewById(R.id.txt_context);
        }
    }
}