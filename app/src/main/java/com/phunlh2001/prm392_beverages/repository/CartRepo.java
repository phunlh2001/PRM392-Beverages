package com.phunlh2001.prm392_beverages.repository;

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
    private LiveData<List<Product>> allCartItemsLiveData;
    private Executor executor = Executors.newSingleThreadExecutor();

    public LiveData<List<Product>> getAllCartItemsLiveData() {
        return allCartItemsLiveData;
    }

    public CartRepo(Application application){
        cartDao = AppDatabase.getInstance(application).cartDao();
        allCartItemsLiveData = cartDao.getAllCartItems();
    }

    public void insertCartItem(Product product){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.insertCartItem(product);
            }
        });
    }

    public void deleteCartItem(Product product){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteCartItem(product);
            }
        });
    }

    public void updateQuantity(int id , int quantity) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updateQuantity(id, quantity);
            }
        });
    }

    public void updatePrice(int id , double price){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.updatePrice(id , price);
            }
        });
    }

    public void deleteAllCartItems(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                cartDao.deleteAllItems();
            }
        });
    }
}
