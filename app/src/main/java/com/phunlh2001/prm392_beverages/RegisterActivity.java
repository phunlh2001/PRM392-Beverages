package com.phunlh2001.prm392_beverages;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;
import com.phunlh2001.prm392_beverages.utils.Hash;

import org.jetbrains.annotations.Contract;

import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtEmail, edtName, edtPhone, edtPassword, edtAddress, edtConfirmPwd;
    private Button btnRegister;
    private UserDao userDao;

    private void initialize() {
        edtEmail = findViewById(R.id.edtEmail);
        edtName = findViewById(R.id.edtFullName);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        edtAddress = findViewById(R.id.edtAddress);
        edtConfirmPwd = findViewById(R.id.edtConfirmPassword);

        btnRegister = findViewById(R.id.btnRegister);

        userDao = AppDatabase.getInstance(this).userDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initialize();

        // Set click listener for sign up button
        btnRegister.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        // Get input values
        String email = edtEmail.getText().toString().trim();
        String fullName = edtName.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String address = edtAddress.getText().toString().trim();
        String confirmPwd = edtConfirmPwd.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(fullName) || TextUtils.isEmpty(phone) ||
                TextUtils.isEmpty(password) || TextUtils.isEmpty(address) || TextUtils.isEmpty(confirmPwd)) {
            Toast.makeText(RegisterActivity.this, "Must be fulfill input", Toast.LENGTH_SHORT).show();
        } else {
            try {
                // Validate email
                if (!isValidEmail(email)) {
                    Toast.makeText(RegisterActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                    throw new Exception("Invalid email address");
                } else if (!isValidName(fullName)) {
                    Toast.makeText(RegisterActivity.this, "Invalid name (maximum 20 words)", Toast.LENGTH_SHORT).show();
                    throw new Exception("Invalid name");
                } else if (!isValidPhone(phone)) {
                    Toast.makeText(RegisterActivity.this, "Invalid phone number", Toast.LENGTH_SHORT).show();
                    throw new Exception("Invalid phone number");
                } else if (!password.equals(confirmPwd)) {
                    Toast.makeText(RegisterActivity.this, "Confirm password incorrect", Toast.LENGTH_SHORT).show();
                    throw new Exception("Confirm password incorrect");
                } else {
                    // Create a new User object
                    User user = new User(email, Hash.Md5(password), fullName, address, phone);
                    user.setAvatar(null);
                    user.setRole(null);
                    user.setCreateAt(null);
                    // Insert the user into the database using UserDao
                    userDao.insert(user);

                    // Show a success message
                    Toast.makeText(RegisterActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z]\\w*@[a-zA-Z]\\w*(\\.[a-zA-Z]\\w*)+$");
    }

    private boolean isValidName(String name) {
        return name.split(" ").length <= 20;
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$");
    }
}