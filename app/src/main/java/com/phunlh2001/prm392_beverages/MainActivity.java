package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.snackbar.Snackbar;
import com.phunlh2001.prm392_beverages.adapters.ProductItemAdapter;
import com.phunlh2001.prm392_beverages.data.entities.Product;
import com.phunlh2001.prm392_beverages.data.entities.ProductItem;
import com.phunlh2001.prm392_beverages.viewmodel.CartViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductItemAdapter.ProductClickedListeners {
    private RecyclerView recyclerView;
    private List<Product> productList;
    private List<ProductItem> productItemList;
    private ProductItemAdapter adapter;
    private CartViewModel viewModel;
    private CoordinatorLayout coordinatorLayout;
    private ImageView cartImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        initializeVariables();
        setUpList();

        adapter.setProductItemList(productItemList);
        recyclerView.setAdapter(adapter);


        cartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.getAllCartItems().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                productList.addAll(products);
            }
        });
    }

    private void setUpList() {
        productItemList.add(new ProductItem("res/drawable-v24/black_coffee.png", "Black Coffee", "delicious", 25.000));
        productItemList.add(new ProductItem("res/drawable-v24/black_coffee.png", "Black Coffee", "delicious", 25.000));
        productItemList.add(new ProductItem("res/drawable-v24/black_coffee.png", "Black Coffee", "delicious", 25.000));
        productItemList.add(new ProductItem("res/drawable-v24/black_coffee.png", "Black Coffee", "delicious", 25.000));
        productItemList.add(new ProductItem("res/drawable-v24/black_coffee.png", "Black Coffee", "delicious", 25.000));
        productItemList.add(new ProductItem("res/drawable-v24/black_coffee.png", "Black Coffee", "delicious", 25.000));
    }

    private void initializeVariables() {
        cartImageView = findViewById(R.id.ivCart);
        coordinatorLayout = findViewById(R.id.coordinatorLayout);
        productList = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CartViewModel.class);
        productItemList = new ArrayList<>();
        recyclerView = findViewById(R.id.rcvListProduct);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new ProductItemAdapter(this);
    }

    @Override
    public void onCardClicked(ProductItem product) {
        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra("productItem", product);
        startActivity(intent);
    }

    @Override
    public void onAddToCartBtnClicked(ProductItem productItem) {
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

        makeSnackBar("Item Added To Cart");
    }

    private void makeSnackBar(String msg) {
        Snackbar.make(coordinatorLayout, msg, Snackbar.LENGTH_SHORT)
                .setAction("Go to Cart", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, CartActivity.class));
                    }
                }).show();
    }
}