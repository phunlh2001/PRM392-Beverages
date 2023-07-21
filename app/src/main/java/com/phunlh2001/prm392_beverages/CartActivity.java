package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phunlh2001.prm392_beverages.adapters.CartAdapter;
import com.phunlh2001.prm392_beverages.data.entities.OrderDetail;
import com.phunlh2001.prm392_beverages.viewmodel.CartViewModel;

import java.util.List;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartClickedListeners{
    private RecyclerView rcvCart;
    private CartViewModel cartViewModel;
    private TextView tvTotalCartPrice;
    private AppCompatButton btnCheckout;
    private CardView cardView;
    private LinearLayout layoutTotalPrice;
    private CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_cart);

        initializeVariables();

        cartViewModel.getAllCartItems().observe(this, new Observer<List<OrderDetail>>() {
            @Override
            public void onChanged(List<OrderDetail> orderDetails) {
                double price = 0;
                cartAdapter.setProductCartList(orderDetails);
                for (int i=0;i<orderDetails.size();i++) {
                    price = price + (orderDetails.get(i).getQuantity() * cartViewModel.getProductPriceById());
                }
                tvTotalCartPrice.setText(String.valueOf(price));
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartViewModel.deleteAllCartItems();
                layoutTotalPrice.setVisibility(View.INVISIBLE);
                cardView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initializeVariables() {
        cartAdapter = new CartAdapter(this);
        rcvCart = findViewById(R.id.rcvCart);
        tvTotalCartPrice = findViewById(R.id.tvTotalCartPrice);
        btnCheckout = findViewById(R.id.btnCheckout);
        cardView = findViewById(R.id.cvCartItem);
        layoutTotalPrice = findViewById(R.id.layoutTotalPrice);

        cartViewModel = new ViewModelProvider(this).get(CartViewModel.class);
        rcvCart.setHasFixedSize(true);
        rcvCart.setLayoutManager(new LinearLayoutManager(this));

        rcvCart.setAdapter(cartAdapter);
    }

    @Override
    public void onDeleteClicked(OrderDetail orderDetail) {
        cartViewModel.deleteCartItem(orderDetail);
    }

    @Override
    public void onPlusClicked(OrderDetail orderDetail) {
        int quantity = orderDetail.getQuantity() + 1;
        cartViewModel.updateQuantity(orderDetail.getProduct_id(), orderDetail.getOrder_id() , quantity);
        cartAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMinusClicked(OrderDetail orderDetail) {
        int quantity = orderDetail.getQuantity() - 1;
        if (quantity != 0){
            cartViewModel.updateQuantity(orderDetail.getProduct_id(), orderDetail.getOrder_id() , quantity);
            cartAdapter.notifyDataSetChanged();
        }else{
            cartViewModel.deleteCartItem(orderDetail);
        }
    }
}