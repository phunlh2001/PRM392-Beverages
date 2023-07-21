package com.phunlh2001.prm392_beverages;

import static com.phunlh2001.prm392_beverages.LoginActivity.KEY_LOGIN;
import static com.phunlh2001.prm392_beverages.LoginActivity.PREF_LOGIN;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Chuyển đến GetStartActivity
        Intent intent = new Intent(MainActivity.this, GetStartActivity.class);
        startActivity(intent);
        finish(); // Để loại bỏ MainActivity khỏi ngăn xếp (stack) và không thể quay lại nó sau khi chuyển đến GetStartActivity.
    }
}