package com.phunlh2001.prm392_beverages;

import static com.phunlh2001.prm392_beverages.LoginActivity.KEY_LOGIN;
import static com.phunlh2001.prm392_beverages.LoginActivity.PREF_NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String username = pref.getString(KEY_LOGIN, "");
        if (username.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, GetStartActivity.class);
            startActivity(intent);
        } else {
            TextView tvMain = findViewById(R.id.tvMain);
            ProductDao productDao = AppDatabase.getInstance(this).productDao();
            // test
            tvMain.setText(productDao.getById(2).getTitle());
        }
    }
}