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
import com.phunlh2001.prm392_beverages.data.entities.OrderDetail;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHodler>{
    private CartClickedListeners cartClickedListeners;

    private List<Product> productList;
    private List<OrderDetail> orderDetailList;

    public CartAdapter(CartClickedListeners cartClickedListeners) {
        this.cartClickedListeners = cartClickedListeners;
    }
    public void setProductCartList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public CartViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHodler holder, int position) {
        Product product = productList.get(position);
        OrderDetail orderDetail = orderDetailList.get(position);

        holder.ivCartItemImg.setImageDrawable(Drawable.createFromPath(product.getThumbnail()));
        holder.tvCartTitle.setText(product.getTitle());
        holder.tvCartQuantity.setText(orderDetail.getQuantity() + "");

        holder.ivCartDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onDeleteClicked(orderDetail);
            }
        });


        holder.ivPlusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onPlusClicked(orderDetail);
            }
        });

        holder.ivMinusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartClickedListeners.onMinusClicked(orderDetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (orderDetailList == null) {
            return 0;
        } else {
            return orderDetailList.size();
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
        void onDeleteClicked(OrderDetail orderDetail);
        void onPlusClicked(OrderDetail orderDetail);
        void onMinusClicked(OrderDetail orderDetail);
    }
}
