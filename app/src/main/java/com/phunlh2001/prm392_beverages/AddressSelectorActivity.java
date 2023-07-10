package com.phunlh2001.prm392_beverages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.phunlh2001.prm392_beverages.adapters.SavedPlaceAdapter;
import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.helper.ISavedPlace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddressSelectorActivity extends AppCompatActivity {

    private List<User> userList;
    private RecyclerView rcvUserAddress;
    private SavedPlaceAdapter addressAdapter;
    private UserDao userDao;

    private void initialize() {
        userList = new ArrayList<>();
        rcvUserAddress = findViewById(R.id.rcvAddress);
        userDao = AppDatabase.getInstance(this).userDao();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_selector);
        initialize();

        addressAdapter = new SavedPlaceAdapter(new ISavedPlace() {
            @Override
            public void onClickEditAddress(User user) {
                handleClickEdit(user);
            }

            @Override
            public void onClickDeleteAddress(User user) {
                handleClickDelete(user);
            }
        });

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        rcvUserAddress.setLayoutManager(linearLayout);
        rcvUserAddress.setAdapter(addressAdapter);

        LoadData();
    }

    private void LoadData() {
        userList = userDao.getAll();
        addressAdapter.setData(userList);
    }

    public void addNewAddress(View view) {
        Intent intent = new Intent(AddressSelectorActivity.this, NewAddressActivity.class);
        startActivity(intent);
    }

    private void handleClickEdit(User user) {
        User _user = userDao.getById(user.getId());
        if (_user == null) {
            Toast.makeText(this, "Cannot get this address", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(AddressSelectorActivity.this, NewAddressActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", (Serializable) _user);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    }

    private void handleClickDelete(User user) {
        new AlertDialog.Builder(this)
                .setTitle("Confirmation")
                .setMessage("Do you want to remove this address?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // delete here
                    userDao.delete(user);
                    Toast.makeText(this, "Delete address successfully", Toast.LENGTH_SHORT).show();
                    LoadData();
                })
                .setNegativeButton("No", null)
                .show();
    }
}