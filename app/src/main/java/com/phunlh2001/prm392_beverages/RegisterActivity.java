package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.entities.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText emailEditText, usernameEditText, passwordEditText;
    private Button registerButton;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        // Khởi tạo AppDatabase
        appDatabase = AppDatabase.getInstance(getApplicationContext());

        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        usernameEditText = findViewById(R.id.editTextTextUsername);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        registerButton = findViewById(R.id.buttonRegister);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                User user = new User(email, username, password);

                saveUser(user);
            }
        });
    }

    private void saveUser(User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();

        if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        if (appDatabase.userDao().getById(user.getId()) != null) {
            Toast.makeText(RegisterActivity.this, "ID người dùng đã tồn tại", Toast.LENGTH_SHORT).show();
            return;
        }

        appDatabase.userDao().insertUser(user);

        Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);

        finish();
    }
}