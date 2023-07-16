package com.phunlh2001.prm392_beverages;

import static com.phunlh2001.prm392_beverages.LoginActivity.KEY_LOGIN;
import static com.phunlh2001.prm392_beverages.LoginActivity.PREF_NAME;

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
        SharedPreferences pref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        String email = pref.getString(KEY_LOGIN, "");
        if (email.isEmpty()) {
            Intent intent = new Intent(MainActivity.this, GetStartActivity.class);
            startActivity(intent);
        } else {
            // [TODO] Navigate to your layout to testing here
            Intent intent = new Intent(MainActivity.this, AddressSelectorActivity.class);
            startActivity(intent);
        }
    }
}