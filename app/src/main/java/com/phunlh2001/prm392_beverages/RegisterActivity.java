package com.phunlh2001.prm392_beverages;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText fullNameEditText;
    private Button signUpButton;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // Initialize the UserDao
        userDao = AppDatabase.getInstance(this).userDao();

        // Find views
        emailEditText = findViewById(R.id.Email);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.Password);
        fullNameEditText = findViewById(R.id.edit_fullname);
        signUpButton = findViewById(R.id.buttonRegister);

        // Set click listener for sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        // Get input values
        String email = emailEditText.getText().toString().trim();
        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String fullName = fullNameEditText.getText().toString().trim();

        // Validate email
        if (!isValidEmail(email)) {
            Toast.makeText(RegisterActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate name
        if (!isValidName(fullName)) {
            Toast.makeText(RegisterActivity.this, "Invalid name (maximum 20 words)", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate phone number


        // Create a new User object
        User user = new User(email, username, password, fullName, "blank_avatar.jpg", RoleAccount.USER);

        // Insert the user into the database using UserDao
        userDao.insert(user);

        // Show a success message
        Toast.makeText(RegisterActivity.this, "Account created successfully", Toast.LENGTH_SHORT).show();
    }

    private boolean isValidEmail(String email) {
        return email.contains("@gmail.com");
    }

    private boolean isValidName(String name) {
        return name.split(" ").length <= 20;
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d+");
    }
}