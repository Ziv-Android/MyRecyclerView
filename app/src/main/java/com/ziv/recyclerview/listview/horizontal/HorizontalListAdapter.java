package com.ziv.recyclerview.listview.horizontal;

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
public class HorizontalListAdapter extends RecyclerView.Adapter<HorizontalListAdapter.HorizontalListViewHolder> {
    private Context mContext;
    private List<String> mData;

    public HorizontalListAdapter(Context context, List list) {
        mContext = context;
        mData = list;
    }

    @Override
    public HorizontalListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        ButterKnife.bind(this, view);
        HorizontalListViewHolder holder = new HorizontalListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalListViewHolder holder, int position) {
        holder.contextTxt.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class HorizontalListViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_context)
        TextView contextTxt;

        public HorizontalListViewHolder(View itemView) {
            super(itemView);
            contextTxt = (TextView) itemView.findViewById(R.id.txt_context);
        }
    }
}
