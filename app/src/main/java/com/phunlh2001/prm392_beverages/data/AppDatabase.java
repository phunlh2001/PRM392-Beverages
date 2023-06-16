package com.phunlh2001.prm392_beverages.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.phunlh2001.prm392_beverages.data.dao.CategoryDao;
import com.phunlh2001.prm392_beverages.data.dao.OrderDao;
import com.phunlh2001.prm392_beverages.data.dao.ProductDao;
import com.phunlh2001.prm392_beverages.data.dao.UserDao;
import com.phunlh2001.prm392_beverages.data.entities.Category;
import com.phunlh2001.prm392_beverages.data.entities.Order;
import com.phunlh2001.prm392_beverages.data.entities.OrderDetail;
import com.phunlh2001.prm392_beverages.data.entities.Product;
import com.phunlh2001.prm392_beverages.data.entities.User;
import com.phunlh2001.prm392_beverages.utils.DateConverter;

@Database(entities = {Category.class, Product.class, User.class, Order.class, OrderDetail.class},
        version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static /* synchronized */ AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"Beverages")
                    .allowMainThreadQueries()
//                    .createFromAsset("database/db.json")
                    .build();
        }
        return INSTANCE;
    }

    // DAOs
    public abstract ProductDao productDao();
    public abstract CategoryDao categoryDao();
    public abstract UserDao userDao();
    public abstract OrderDao orderDao();
}
