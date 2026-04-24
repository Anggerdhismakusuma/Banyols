package com.example.dclassicsbooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {
    private List<StoreCarousel> storeList;

    public CarouselAdapter(List<StoreCarousel> storeList) {
        this.storeList = storeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_carousel, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StoreCarousel item = storeList.get(position);

        holder.imageView.setImageResource(item.getImageRes());
        holder.tvName.setText(item.getName());
        holder.tvAddress.setText(item.getAddress());
        holder.tvPhone.setText(item.getPhone());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName, tvAddress, tvPhone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_carousel_image);
            tvName = itemView.findViewById(R.id.tv_store_name);
            tvAddress = itemView.findViewById(R.id.tv_store_address);
            tvPhone = itemView.findViewById(R.id.tv_store_phone);
        }
    }
}
