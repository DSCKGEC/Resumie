package com.example.resumie.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.resumie.R;

import java.util.List;

public class PortfolioAdapter extends  RecyclerView.Adapter<PortfolioAdapter.PortfolioHolder> {

    List<PortfolioItem> mdata;
    PortfolioCallback listener;

    public PortfolioAdapter(List<PortfolioItem> mdata,PortfolioCallback listener) {
        this.mdata = mdata;
        this.listener = listener;
    }

    @NonNull
    @Override
    public PortfolioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portfolio,parent,false);
        return new PortfolioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(mdata.get(position).getImage()).into(holder.projectimg);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class PortfolioHolder extends RecyclerView.ViewHolder {

        ImageView projectimg;

        public PortfolioHolder(@NonNull View itemView) {
            super(itemView);

            projectimg = itemView.findViewById(R.id.item_portfolio_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onPortfolioItemClick(getAdapterPosition());
                }
            });
        }
      }
    }
