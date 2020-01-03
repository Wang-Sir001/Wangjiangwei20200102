package com.bawei.wangjiangwei20200102.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei20200102.R;
import com.bawei.wangjiangwei20200102.model.entity.HomeEntity;
import com.bumptech.glide.Glide;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private static Context context;
    private List<HomeEntity.Product> list;

    public HomeAdapter(Context context, List<HomeEntity.Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.home_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).imageUrl)
                .into(holder.image);
        holder.name.setText(list.get(position).title);
        holder.name.setText(list.get(position).rank);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView name,price;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
