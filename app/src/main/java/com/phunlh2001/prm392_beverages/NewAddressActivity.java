package com.phunlh2001.prm392_beverages;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;

public class NewAddressActivity extends AppCompatActivity {

    private EditText edtAddress, edtName, edtPhone;
    private Button btnSave;

    private User user;
    private UserDao userDao;

    String strName, strPhone, strAddress;

    private void init() {
        edtAddress = findViewById(R.id.edt_address);
        edtName = findViewById(R.id.edt_recipient_name);
        edtPhone = findViewById(R.id.edt_recipient_phone);
        btnSave = findViewById(R.id.btnSaveAddress);
        userDao = AppDatabase.getInstance(this).userDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);
        init();

//        user = (User) getIntent().getExtras().get("user");
//        if (user != null) {
//            edtAddress.setText(user.getAddress());
//            edtName.setText(user.getFull_name());
//            edtPhone.setText(user.getPhone_number());
//        }

        btnSave.setOnClickListener(v -> handleClickSave());
    }

    private void handleClickSave() {
        getData();
        if (TextUtils.isEmpty(strName) || TextUtils.isEmpty(strAddress) || TextUtils.isEmpty(strPhone)) {
            insertAddress();
        } else {
            updateAddress();
        }
    }

    private void insertAddress() {

        userDao.insert(user);
        Toast.makeText(this, "Update address successfully", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(NewAddressActivity.this, AddressSelectorActivity.class);
        startActivity(intent);
        finish();
    }

    private void updateAddress() {
        getData();

    }

    private void getData() {
        strName = edtName.getText().toString().trim();
        strAddress = edtAddress.getText().toString().trim();
        strPhone = edtPhone.getText().toString().trim();
    }

//    private <T> void getListToSpinner(ArrayAdapter<T> adapter, @NonNull Spinner spinner, T[] list) {
//        adapter = new ArrayAdapter<>(this, R.layout.address_spinner_item, list);
//        adapter.setDropDownViewResource(R.layout.address_spinner_item);
//        spinner.setAdapter(cityAdapter);
//        spinner.setSelection(0);
//    }
}