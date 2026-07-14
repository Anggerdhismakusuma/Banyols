package com.example.dclassicsbooks;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreListAdapter extends RecyclerView.Adapter<StoreListAdapter.ViewHolder> {

    List<Store> list;

    public StoreListAdapter(List<Store> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, address, phone;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            address = itemView.findViewById(R.id.tvAddress);
            phone = itemView.findViewById(R.id.tvPhone);
            image = itemView.findViewById(R.id.imgStore);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Store data = list.get(position);
        holder.name.setText(data.name);
        holder.address.setText(data.address);
        holder.phone.setText(data.phone);
        holder.image.setImageResource(data.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
