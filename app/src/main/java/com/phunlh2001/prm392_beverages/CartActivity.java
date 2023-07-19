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
import com.phunlh2001.prm392_beverages.data.entities.Product;
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

        cartViewModel.getAllCartItems().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                double price = 0;
                cartAdapter.setProductCartList(products);
                for (int i=0;i<products.size();i++){
                    price = price + products.get(i).getTotalItemPrice();
                }
                tvTotalCartPrice.setText(String.valueOf(price));
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartViewModel.deleteAllCartItems();
                cardView.setVisibility(View.VISIBLE);
                layoutTotalPrice.setVisibility(View.INVISIBLE);
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
    public void onDeleteClicked(Product product) {
        cartViewModel.deleteCartItem(product);
    }

    @Override
    public void onPlusClicked(Product product) {
        int quantity = product.getQuantity() + 1;
        cartViewModel.updateQuantity(product.getId() , quantity);
        cartViewModel.updatePrice(product.getId() , quantity*product.getPrice());
        cartAdapter.notifyDataSetChanged();
    }

    @Override
    public void onMinusClicked(Product product) {
        int quantity = product.getQuantity() - 1;
        if (quantity != 0){
            cartViewModel.updateQuantity(product.getId() , quantity);
            cartViewModel.updatePrice(product.getId() , quantity*product.getPrice());
            cartAdapter.notifyDataSetChanged();
        }else{
            cartViewModel.deleteCartItem(product);
        }
    }
}