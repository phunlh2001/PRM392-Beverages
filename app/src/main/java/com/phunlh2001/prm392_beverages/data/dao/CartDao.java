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

    @Query("UPDATE OrderDetails SET quantity_product=:quantity " +
            "WHERE (SELECT Products.id=:id FROM Products " +
            "WHERE Products.id = OrderDetails.product_id)")
    void updateQuantity(int id, int quantity);

    @Query("UPDATE OrderDetails SET totalItemPrice=:totalItemPrice " +
            "WHERE (SELECT Products.id=:id FROM Products " +
            "WHERE Products.id = OrderDetails.product_id)")
    void updatePrice(int id, double totalItemPrice);

    @Query("DELETE FROM OrderDetails")
    void deleteAllItems();
}
