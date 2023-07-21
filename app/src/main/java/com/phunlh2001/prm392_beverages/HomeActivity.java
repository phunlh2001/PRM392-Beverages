package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout navigateStore, navigateDelivery;

    private void initialize() {
        navigateDelivery = findViewById(R.id.btn_delivery);
        navigateStore = findViewById(R.id.btn_store_pickup);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialize();

        navigateStore.setOnClickListener(v -> {

        });

        navigateDelivery.setOnClickListener(v -> {

        });
    }
}