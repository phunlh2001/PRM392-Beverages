package com.phunlh2001.prm392_beverages;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.List;

public class ProductDetailActivity extends AppCompatActivity {
    private List<Product> productQuery;
    private Product product;
    private TextView tvName;
    private TextView tvPrice;
    private TextView tvDes;
    private ProductDao productDao;
    private void init() {
        tvName = findViewById(R.id.menu_item_title);
        tvPrice = findViewById(R.id.menu_item_price);
        tvDes = findViewById(R.id.menu_item_des);

        //khoi tao dao
        productDao = AppDatabase.getInstance(this).productDao();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        init();

        //get recived product
        product = (Product) getIntent().getExtras().get("object_product");
        if (product == null) {
            Toast.makeText(this, "Please insert 1st data!please", Toast.LENGTH_SHORT).show();
        } else {
            //fill data to UI
            try {
                //Truy xuat ID tu bundle lay duoc tu RecylerView
                Integer sId = (Integer) product.getId();
                //Truy xuat CSDL =sId de lay full thong tin
                retrieveDataFromDBtoUI(sId);
            } catch (Exception e) {
                Toast.makeText(this, "Error" + e.toString(), Toast.LENGTH_SHORT).show();
            }
        }


    }

    //lay du lieu thong qua id
    private void retrieveDataFromDBtoUI(int ID) {
        try {
             productQuery = (List<Product>) productDao.getById(ID);

            if (productQuery != null) {
                // fill data to UI
                for (Product productItems : productQuery) {
                    tvName.setText(productItems.getTitle());
                    tvPrice.setText(Double.toString(productItems.getPrice()));
                    tvDes.setText(productItems.getDesc());
                }
            } else Toast.makeText(this, "Error: Data is NULL", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }



}