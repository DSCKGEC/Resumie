package com.example.resumie.team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resumie.R;

import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    List<TeamItem> mdata;

    public TeamAdapter(List<TeamItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team,parent,false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.author_description.setText(mdata.get(position).getAuthor_description());
        holder.author_name.setText(mdata.get(position).getAuthor_name());
        holder.author_icon.setImageResource(mdata.get(position).getAuthor_icon());

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView author_name,author_description;
        ImageView author_icon;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);

            author_description=itemView.findViewById(R.id.author_description);
            author_name=itemView.findViewById(R.id.author_name);
            author_icon=itemView.findViewById(R.id.author_icon);
        }
    }
}
