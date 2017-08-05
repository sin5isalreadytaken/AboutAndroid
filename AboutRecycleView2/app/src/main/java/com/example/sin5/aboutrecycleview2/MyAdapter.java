package com.example.sin5.aboutrecycleview2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by sin5 on 2016/5/24.
 */
public class MyAdapter extends RecyclerView.Adapter{
    class ViewHolder extends RecyclerView.ViewHolder{
        private View tv;
        private TextView tvTitle;
        private TextView tvContent;

        public ViewHolder(View itemView){
            super(itemView);
            tv = itemView;
            tvTitle = (TextView) tv.findViewById(R.id.tv1);
            tvContent = (TextView) tv.findViewById(R.id.tv2);
        }

        public View getTv(){
            return tv;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContent() {
            return tvContent;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.items, null));//布局解释器
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        CellData data = cd[position];
        vh.getTvTitle().setText(data.title);
        vh.getTvContent().setText(data.content);
    }

    @Override
    public int getItemCount() {
        return cd.length;
    }

    private CellData[] cd = new CellData[]{new CellData("1","2"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3"),new CellData("2" , "3"),new CellData("1","2"),new CellData("2" , "3")};
}
