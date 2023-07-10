package com.phunlh2001.prm392_beverages;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;
import androidx.appcompat.app.AppCompatActivity;

import com.phunlh2001.prm392_beverages.data.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton, createAccountButton; // Add createAccountButton

    private UserDao userDao;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // Initialize database and DAO
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        userDao = appDatabase.userDao();
        executorService = Executors.newSingleThreadExecutor();

        // Initialize views
        usernameEditText = findViewById(R.id.editTextText);
        passwordEditText = findViewById(R.id.editTextText2);
        loginButton = findViewById(R.id.button2);
        createAccountButton = findViewById(R.id.Or_Create); // Initialize createAccountButton

        // Set click listener for login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // Set click listener for create account button
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToRegister(); // Call navigateToRegister() method
            }
        });
    }

    private void loginUser() {
        // ... Remaining code for loginUser() method
    }

    private void navigateToRegister() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Shutdown ExecutorService when the activity is destroyed
        executorService.shutdown();
    }
}
