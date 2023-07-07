package com.phunlh2001.prm392_beverages.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.phunlh2001.prm392_beverages.data.AppDatabase;
import com.phunlh2001.prm392_beverages.data.dao.CartDao;
import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CartRepo {
    private CartDao cartDao;
    private LiveData<List<Product>> allCartItemLiveData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<Product>> getAllCartItemLiveData() {
        return allCartItemLiveData;
    }

    public CartRepo(Application application) {
        cartDao = AppDatabase.getInstance(application).cartDao();
        allCartItemLiveData = cartDao.getAllCartItems();
    }

    public void insertCartItem(Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.insertCartItem(product);
            }
        });
    }

    public void deleteCartItem(Product product) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteCartItem(product);
            }
        });
    }

    public void updateQuantity(int id, int quantity) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updateQuantity(id, quantity);
            }
        });
    }

    public void updateTotalPrice(int id, double totalItemPrice) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updatePrice(id, totalItemPrice);
            }
        });
    }
}
