package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.phunlh2001.prm392_beverages.adapters.MenuAdapter;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.List;

public class DeliveryMenuActivity extends AppCompatActivity {

    private RecyclerView rcvMenu;
    private MenuAdapter deliveryMenuAdapter;
    private List<Product> _list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_menu);

        rcvMenu = findViewById(R.id.rcv_menu);
        deliveryMenuAdapter = new MenuAdapter(this);

        GridLayoutManager gridLayoutManager =new GridLayoutManager(this, 3);
        rcvMenu.setLayoutManager(gridLayoutManager);

        deliveryMenuAdapter.setData(_list);
        rcvMenu.setAdapter(deliveryMenuAdapter);
    }

    private List<Product> getListProduct() {
        return null;
    }
}