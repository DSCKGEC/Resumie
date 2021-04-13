package com.example.resumie.portfolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumie.R;

import java.util.List;

public class PortfolioAdapter extends  RecyclerView.Adapter<PortfolioAdapter.PortfolioHolder> {

    List<PortfolioItem> mdata;

    public PortfolioAdapter(List<PortfolioItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public PortfolioHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portfolio,parent,false);
        return new PortfolioHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioHolder holder, int position) {
        holder.position.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class PortfolioHolder extends RecyclerView.ViewHolder {

        TextView position;

        public PortfolioHolder(@NonNull View itemView) {
            super(itemView);

            position= itemView.findViewById(R.id.portfolio_text);


        }
      }
    }
