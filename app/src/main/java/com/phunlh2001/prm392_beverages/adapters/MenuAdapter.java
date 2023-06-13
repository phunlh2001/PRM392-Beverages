package com.phunlh2001.prm392_beverages.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phunlh2001.prm392_beverages.R;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {
    private List<Product> _products;
    private Context context;

    public MenuAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Product> list) {
        _products = list;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Product prod = _products.get(position);
        if (prod == null) return;

//        holder.thumbnail.setImageResource(prod.getThumbnail());
        holder.title.setText(prod.getTitle());
        holder.price.setText("" + prod.getPrice());
    }

    @Override
    public int getItemCount() {
        if (_products != null) return _products.size();
        return 0;
    }

    public static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView title, price;
        ImageView thumbnail;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.menu_item_title);
            price = itemView.findViewById(R.id.menu_item_price);
            thumbnail = itemView.findViewById(R.id.img_item_menu);
        }
    }
}
