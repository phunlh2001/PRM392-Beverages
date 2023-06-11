package com.phunlh2001.prm392_beverages.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.phunlh2001.prm392_beverages.data.entities.Category;
import com.phunlh2001.prm392_beverages.data.entities.Staff;

import java.util.List;

@Dao
public interface StaffDao {
    @Insert
    void insert(Staff staff);

    @Update
    void update(Staff staff);

    @Delete
    void delete(Staff staff);

    @Query("SELECT * FROM staffs")
    LiveData<List<Staff>> getAll();

    @Query("SELECT * FROM staffs WHERE id=:id")
    LiveData<Staff> getById(int id);
}
