package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.phunlh2001.prm392_beverages.data.entities.Product;
import com.phunlh2001.prm392_beverages.data.entities.ProductItem;
import com.phunlh2001.prm392_beverages.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {
    private ImageView ivDetailedProduct;
    private TextView tvDetailedTitle, tvDetailedPrice, tvDetailedDesc;
    private AppCompatButton btnDetailedAddToCart;
    private ProductItem product;
    private CartViewModel viewModel;
    private List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        product = getIntent().getParcelableExtra("shoeItem");
        initializeVariables();

        viewModel.getAllCartItems().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productList.addAll(products);
            }
        });

        if (product != null) {
            setDataToWidgets();
        }

        btnDetailedAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertToRoom();
            }
        });
    }

    private void insertToRoom() {
        Product product = new Product();
        product.setTitle(product.getTitle());
        product.setThumbnail(product.getThumbnail());
        product.setPrice(product.getPrice());
        product.setDesc(product.getDesc());

        final int[] quantity = {1};
        final int[] id = new int[1];

        if (!productList.isEmpty()) {
            for (int i = 0; i < productList.size(); i++) {
                if (product.getTitle().equals(productList.get(i).getTitle())) {
                    quantity[0] = productList.get(i).getQuantity();
                    quantity[0]++;
                    id[0] = productList.get(i).getId();
                }
            }
        }

        Log.d("TAG", "onAddToCartBtnClicked: " + quantity[0]);

        if (quantity[0] == 1) {
            product.setQuantity(quantity[0]);
            product.setTotalItemPrice(quantity[0] * product.getPrice());
            viewModel.insertCartItem(product);
        } else {
            viewModel.updateQuantity(id[0], quantity[0]);
            viewModel.updatePrice(id[0], quantity[0] * product.getPrice());
        }

        startActivity(new Intent(DetailedActivity.this , CartActivity.class));
    }

    private void setDataToWidgets() {
        tvDetailedTitle.setText(product.getTitle());
        tvDetailedPrice.setText(String.valueOf(product.getPrice()));
        tvDetailedDesc.setText(product.getDesc());
        ivDetailedProduct.setImageDrawable(Drawable.createFromPath(product.getThumbnail()));
    }

    private void initializeVariables() {
        productList = new ArrayList<>();
        ivDetailedProduct = findViewById(R.id.ivDetailedProduct);
        tvDetailedTitle = findViewById(R.id.tvDetailedTitle);
        tvDetailedPrice = findViewById(R.id.tvDetailedPrice);
        tvDetailedDesc = findViewById(R.id.tvDetailedDesc);
        btnDetailedAddToCart = findViewById(R.id.btnDetailedAddToCart);

        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
    }
}