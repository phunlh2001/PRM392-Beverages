package com.phunlh2001.prm392_beverages.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.phunlh2001.prm392_beverages.data.entities.Product;
import com.phunlh2001.prm392_beverages.repository.CartRepo;

import java.util.List;

public class CartViewModel extends AndroidViewModel {
    private CartRepo cartRepo;

    public CartViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getAllCartItems() {
        return cartRepo.getAllCartItemsLiveData();
    }

    public void insertCartItem(Product product) {
        cartRepo.insertCartItem(product);
    }

    public void updateQuantity(int id, int quantity) {
        cartRepo.updateQuantity(id, quantity);
    }

    public void updatePrice(int id, double price) {
        cartRepo.updatePrice(id, price);
    }

    public void deleteCartItem(Product product) {
        cartRepo.deleteCartItem(product);
    }

    public void deleteAllCartItems() {
        cartRepo.deleteAllCartItems();
    }
}
