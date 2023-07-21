package com.phunlh2001.prm392_beverages;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvFullName, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        tvFullName = findViewById(R.id.tvFullName);
        tvEmail = findViewById(R.id.tvEmail);

        // Nhận thông tin người dùng từ Intent
        String userName = getIntent().getStringExtra("user_name");
        String userEmail = getIntent().getStringExtra("email");

        // Hiển thị thông tin người dùng lên TextViews
        tvFullName.setText(userName);
        tvEmail.setText("Email: " + userEmail);
    }
}
