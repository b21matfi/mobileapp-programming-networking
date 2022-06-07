package com.example.networking;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Mountain> itemsList;
    public MyAdapter(List<Mountain> itemsList) {
        this.itemsList = itemsList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mountain_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(itemsList.get(position).getName());
        holder.location.setText(itemsList.get(position).getLocation());
        holder.size.setText(itemsList.get(position).getSize());
    }

    @Override
    public int getItemCount() {
        return itemsList.size();

    }

    public void setitemslist(List<Mountain> items) {
        this.itemsList = items;
    }
}
