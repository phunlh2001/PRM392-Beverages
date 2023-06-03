package com.phunlh2001.prm392_beverages.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.phunlh2001.prm392_beverages.data.entities.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM users")
    void getAll();

    @Query("SELECT * FROM users WHERE user_id=:id")
    void getById(int id);
}
