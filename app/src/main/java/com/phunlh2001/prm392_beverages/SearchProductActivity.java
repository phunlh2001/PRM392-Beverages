package com.phunlh2001.prm392_beverages;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.phunlh2001.prm392_beverages.adapters.ProductAdapter;
import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchProductActivity extends AppCompatActivity {
    private Button btnSearch;
    private EditText edtSearch;
    private RecyclerView rcvProduct;
    private ProductAdapter productAdapter;
    private List<Product> _list;
    private ProductDao productDao;

    private void init() {
        // anh xa view
        rcvProduct = findViewById(R.id.rcv_product);
        btnSearch = findViewById(R.id.btn_search);
        edtSearch = findViewById(R.id.edt_search);
        // khoi tao adapter
        productAdapter = new ProductAdapter(this);

        // khoi tao dao
        productDao = AppDatabase.getInstance(this).productDao();
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);

        init();
        viewProduct();

        //on click search
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSearchProduct();
            }
        });
    }

    private void viewProduct() {
        // tao rcv
        GridLayoutManager gridLayoutManager =new GridLayoutManager(this, 1);
        rcvProduct.setLayoutManager(gridLayoutManager);

        // set data
        _list = new ArrayList<>();
        List<Product> _list = productDao.getAll();
        productAdapter.setData(_list);

        // set adapter cho rcvMenu
        rcvProduct.setAdapter(productAdapter);
    }

    private void handleSearchProduct() {
        String strKeyword = edtSearch.getText().toString().trim();
        //tao list product rong truoc khi them du lieu da search
        _list = new ArrayList<>();
        _list = AppDatabase.getInstance(this).productDao().searchProduct(strKeyword);
        productAdapter.setData(_list);
    }
}