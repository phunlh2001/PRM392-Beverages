package com.phunlh2001.prm392_beverages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.utils.Hash;

public class LoginActivity extends AppCompatActivity {

    public static final String PREF_LOGIN = "PrefBeveragesLogin";
    public static final String KEY_LOGIN = "User_Email";

    private EditText edtEmail, edtPwd;
    private Button btnLogin, btnRegister;
    private UserDao userDao;

    private SharedPreferences pref;

    private void initialize() {
        edtEmail = findViewById(R.id.edt_email);
        edtPwd = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_Login);
        btnRegister = findViewById(R.id.Or_Create);

        userDao = AppDatabase.getInstance(this).userDao();

        pref = getSharedPreferences(PREF_LOGIN, Context.MODE_PRIVATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        initialize();

        // Set click listener for login button
        btnLogin.setOnClickListener(view -> loginUser());

        // Set click listener for create account button
        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    private void loginUser() {
        // Get input values
        String email = edtEmail.getText().toString().trim();
        String password = edtPwd.getText().toString().trim();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Must be fill in all blank", Toast.LENGTH_SHORT).show();
        } else {
            User user = userDao.getUserByEmail(email);
            if (user == null || !user.getPassword().equals(Hash.Md5(password))) {
                Toast.makeText(this, "Email or password incorrect", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences.Editor editor = pref.edit();
                editor.putString(KEY_LOGIN, email);
                boolean isLogin = editor.commit();

                if (isLogin) {
                    Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
