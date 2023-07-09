package com.phunlh2001.prm392_beverages;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText, usernameEditText, passwordEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        // Tìm các thành phần giao diện bằng ID
        emailEditText = findViewById(R.id.editTextText6);
        usernameEditText = findViewById(R.id.editTextText7);
        passwordEditText = findViewById(R.id.editTextText8);
        signUpButton = findViewById(R.id.button4);

        // Đăng ký sự kiện click cho nút Sign Up
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các EditText
                String email = emailEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Kiểm tra các trường dữ liệu không được để trống
                if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lưu dữ liệu vào cơ sở dữ liệu hoặc thực hiện các tác vụ khác ở đây

                // Hiển thị thông báo thành công
                Toast.makeText(RegisterActivity.this, "Sign Up successful", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
