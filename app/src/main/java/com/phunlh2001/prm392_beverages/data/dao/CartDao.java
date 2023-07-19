package com.phunlh2001.prm392_beverages.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.phunlh2001.prm392_beverages.data.entities.Product;

import java.util.List;

@Dao
public interface CartDao {
    @Insert
    void insertCartItem(Product product);

    @Query("SELECT * FROM Products")
    LiveData<List<Product>> getAllCartItems();

    @Delete
    void deleteCartItem(Product product);

    @Query("UPDATE Products SET quantity=:quantity " +
            "WHERE id=:id")
    void updateQuantity(int id, int quantity);

    @Query("UPDATE Products SET totalItemPrice=:totalItemPrice " +
            "WHERE id=:id")
    void updatePrice(int id, double totalItemPrice);

    @Query("DELETE FROM Products")
    void deleteAllItems();
}
