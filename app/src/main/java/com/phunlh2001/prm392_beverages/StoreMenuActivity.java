package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.phunlh2001.prm392_beverages.adapters.CategoryAdapter;
import com.phunlh2001.prm392_beverages.adapters.ProductMenuAdapter;
import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.entities.Product;
import com.phunlh2001.prm392_beverages.viewmodel.CategoryViewModel;

import java.util.ArrayList;
import java.util.List;

public class StoreMenuActivity extends AppCompatActivity {

    private RecyclerView rcvMenu, rcvCate;
    private ProductMenuAdapter productMenuAdapter;
    private CategoryAdapter categoryAdapter;
    private ProductDao productDao;

    private void initialize() {
        rcvMenu = findViewById(R.id.rcv_menu);
        rcvCate = findViewById(R.id.rcv_cates);
        productMenuAdapter = new ProductMenuAdapter(this);
        categoryAdapter = new CategoryAdapter(this);
        productDao = AppDatabase.getInstance(this).productDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_menu);
        initialize();

        recyclerViewCategory();
        recyclerViewProduct();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvCate.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryViewModel> categories = new ArrayList<>();
        categories.add(new CategoryViewModel("Coffee", "cate_coffee"));
        categories.add(new CategoryViewModel("Tea", "cate_tea"));
        categories.add(new CategoryViewModel("Freeze", "cate_freeze"));
        categories.add(new CategoryViewModel("Mojito", "cate_mojito"));
        categories.add(new CategoryViewModel("Smoothie", "cate_smoothie"));

        categoryAdapter.setData(categories);
        rcvCate.setAdapter(categoryAdapter);
    }

    private void recyclerViewProduct() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        rcvMenu.setLayoutManager(gridLayoutManager);

        List<Product> _list = productDao.getAll();
        productMenuAdapter.setData(_list);
        rcvMenu.setAdapter(productMenuAdapter);
    }
}