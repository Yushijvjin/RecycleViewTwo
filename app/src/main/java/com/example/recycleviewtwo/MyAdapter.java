package com.example.recycleviewtwo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 李小兵 on 2017/2/5.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private ArrayList<String> slist;
    private Context context;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {

    }

    public MyAdapter( ArrayList<String> slist,Context context，OnItemClickListener onItemClickListener) {
        this.context = context;
        this.slist = slist;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycle_item,null));

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_recycle.setText(slist.get(position)+"");

        if (onItemClickListener!=null) {
            holder.tv_recycle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onItemClickListener.onItemClickListener(v, position);

                }
            });
        }
        if (onItemClickListener!=null){

            holder.tv_recycle.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {


                    onItemClickListener.onItemLongClickListener(v,position);
                    return false;
                }
            });


        }




    }

    @Override
    public int getItemCount() {
        return slist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private  TextView tv_recycle;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_recycle = (TextView) itemView.findViewById(R.id.tv_recycle);

        }
    }






}
