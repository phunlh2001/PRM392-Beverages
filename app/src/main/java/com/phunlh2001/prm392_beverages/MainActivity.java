package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.entities.Product;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;

    private void init() {
        tvMain = findViewById(R.id.tvMain);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

//        tvMain.setText(AppDatabase.getInstance(this).productDao().getById(1).getTitle());
    }
}