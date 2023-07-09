package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;

public class MainActivity extends AppCompatActivity {

    TextView tvMain;
    ProductDao dao;

    private void init() {
        tvMain = findViewById(R.id.tvMain);
        dao = AppDatabase.getInstance(MainActivity.this).productDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        tvMain.setText(dao.getById(1).getTitle());
    }
}