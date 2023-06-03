package com.phunlh2001.prm392_beverages.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.phunlh2001.prm392_beverages.data.entities.Product;

@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("SELECT * FROM products")
    void getAll();

    @Query("SELECT * FROM products WHERE id=:id")
    void getById(int id);
}
