package com.phunlh2001.prm392_beverages.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.phunlh2001.prm392_beverages.data.entities.Staff;

@Dao
public interface StaffDao {
    @Insert
    void insert(Staff staff);

    @Update
    void update(Staff staff);

    @Delete
    void delete(Staff staff);

    @Query("SELECT * FROM staffs")
    void getAll();

    @Query("SELECT * FROM staffs WHERE id=:id")
    void getById(int id);
}
