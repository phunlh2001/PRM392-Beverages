package com.phunlh2001.prm392_beverages.adapters;

import android.graphics.drawable.Drawable;
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

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHodler>{
    private CartClickedListeners cartClickedListeners;
    private List<Product> productList;

    public CartAdapter(CartClickedListeners cartClickedListeners) {
        this.cartClickedListeners = cartClickedListeners;
    }
    public void setProductCartList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CartViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.CartViewHodler holder, int position) {
        Product product = productList.get(position);
        holder.ivCartItemImg.setImageDrawable(Drawable.createFromPath(product.getThumbnail()));
        holder.tvCartTitle.setText(product.getTitle());
        holder.tvCartPrice.setText(product.getTotalItemPrice() + "");
        holder.tvCartQuantity.setText(product.getQuantity() + "");

        holder.ivCartDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onDeleteClicked(product);
            }
        });


        holder.ivPlusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onPlusClicked(product);
            }
        });

        holder.ivMinusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onMinusClicked(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (productList == null) {
            return 0;
        } else {
            return productList.size();
        }
    }

    public class CartViewHodler extends RecyclerView.ViewHolder {
        private TextView tvCartTitle, tvCartPrice, tvCartQuantity;
        private ImageView ivCartItemImg, ivCartDelete, ivPlusItem, ivMinusItem;
        public CartViewHodler(@NonNull View itemView) {
            super(itemView);

            tvCartTitle = itemView.findViewById(R.id.tvCartTitle);
            tvCartPrice = itemView.findViewById(R.id.tvCartPrice);
            tvCartQuantity = itemView.findViewById(R.id.tvCartQuantity);
            ivCartDelete = itemView.findViewById(R.id.ivCartDelete);
            ivCartItemImg = itemView.findViewById(R.id.ivCartItemImg);
            ivPlusItem = itemView.findViewById(R.id.ivPlusItem);
            ivMinusItem = itemView.findViewById(R.id.ivMinusItem);
        }
    }

    public interface CartClickedListeners {
        void onDeleteClicked(Product product);

        void onPlusClicked(Product product);

        void onMinusClicked(Product product);
    }
}
