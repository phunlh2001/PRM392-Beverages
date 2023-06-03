package com.phunlh2001.prm392_beverages.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.phunlh2001.prm392_beverages.data.entities.Order;

@Dao
public interface OrderDao {
    @Insert
    void insert(Order orders);

    @Update
    void update(Order orders);

    @Delete
    void delete(Order orders);

    @Query("SELECT * FROM orders")
    void getAll();

    @Query("SELECT * FROM orders WHERE id=:id")
    void getById(int id);
}
