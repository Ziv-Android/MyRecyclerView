package com.ziv.recyclerview.listview.vertical;

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
 * Vertical List View Adapter
 * Created by ziv on 16-11-29.
 */
public class VerticalListAdapter extends RecyclerView.Adapter<VerticalListAdapter.VerticalListViewHolder> {
    private Context mContext;
    private List<String> mData;

    public VerticalListAdapter(Context context, List list) {
        mContext = context;
        mData = list;
    }

    @Override
    public VerticalListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        ButterKnife.bind(this, view);
        VerticalListViewHolder holder = new VerticalListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(VerticalListViewHolder holder, int position) {
        holder.contextTxt.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class VerticalListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_context)
        TextView contextTxt;

        public VerticalListViewHolder(View itemView) {
            super(itemView);
            contextTxt = (TextView) itemView.findViewById(R.id.txt_context);
        }
    }
}
