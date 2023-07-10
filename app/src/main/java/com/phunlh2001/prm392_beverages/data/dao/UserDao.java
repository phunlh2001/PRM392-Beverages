package com.phunlh2001.prm392_beverages.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.data.entities.relationship.UserEmbedded;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    long insertUser(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User... user);
    @Query("SELECT * FROM users WHERE username=:username")
    User getUserByUsername(String username);
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE id=:id")
    User getById(int id);

    @Transaction
    @Query("SELECT * FROM users")
    List<UserEmbedded> getAllOrderOfUser();

}
