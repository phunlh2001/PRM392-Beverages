package com.phunlh2001.prm392_beverages.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.phunlh2001.prm392_beverages.data.dao.CategoryDao;
import com.phunlh2001.prm392_beverages.data.dao.OrderDao;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.dao.StaffDao;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.Category;
import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.Product;
import com.phunlh2001.prm392_beverages.data.entities.Staff;
import com.phunlh2001.prm392_beverages.data.entities.User;

@Database(entities = {Category.class, Product.class, Staff.class, User.class, Order.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"Beverages")
                    .allowMainThreadQueries()
//                    .addMigrations(migration_from_1_to_2)
                    .build();
        }
        return INSTANCE;
    }

    // DAOs
    public abstract ProductDao productDao();
    public abstract CategoryDao categoryDao();
    public abstract StaffDao staffDao();
    public abstract UserDao userDao();
    public abstract OrderDao orderDao();
}
