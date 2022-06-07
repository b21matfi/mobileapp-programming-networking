package com.example.networking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView location;
    public TextView size;



    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.mountain_name);
        location = itemView.findViewById(R.id.mountain_location);
        size = itemView.findViewById(R.id.mountain_size);

    }
}
