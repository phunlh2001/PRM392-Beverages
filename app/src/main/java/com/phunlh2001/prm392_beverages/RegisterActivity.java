package com.phunlh2001.prm392_beverages;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

import androidx.appcompat.app.AppCompatActivity;

import com.phunlh2001.prm392_beverages.data.AppDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText, usernameEditText, passwordEditText, fullNameEditText;
    private Button registerButton;

    private UserDao userDao;
    private ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // Initialize database and DAO
        AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
        userDao = appDatabase.userDao();
        executorService = Executors.newSingleThreadExecutor();

        // Initialize views
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        usernameEditText = findViewById(R.id.editTextTextUsername);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        fullNameEditText = findViewById(R.id.edit_fullname);
        registerButton = findViewById(R.id.buttonRegister);

        // Set click listener for register button
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Get user input
        String email = emailEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String fullName = fullNameEditText.getText().toString().trim();

        // Validate user input
        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || fullName.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate email format
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid email format. Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate full name (only allow letters)
        if (!fullName.matches("[a-zA-Z ]+")) {
            Toast.makeText(this, "Invalid full name. Please enter letters only", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate username (only allow letters)
        if (!username.matches("[a-zA-Z]+")) {
            Toast.makeText(this, "Invalid username. Please enter letters only", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate password length
        if (password.length() > 15) {
            Toast.makeText(this, "Password must not exceed 15 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new user object
        User user = new User(email, username, password, fullName, null, RoleAccount.USER);

        // Insert the user into the database using ExecutorService
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                userDao.insert(user);
            }
        });

        // Display success message
        Toast.makeText(this, "User registered successfully", Toast.LENGTH_SHORT).show();

        // Start LoginActivity
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);

        // Finish the activity
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Shutdown ExecutorService when the activity is destroyed
        executorService.shutdown();
    }
}
