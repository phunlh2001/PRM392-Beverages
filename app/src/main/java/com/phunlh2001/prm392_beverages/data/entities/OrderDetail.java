package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(tableName = "OrderDetails",
        primaryKeys = {"product_id", "order_id"},
        foreignKeys = {
            @ForeignKey(entity = Product.class,
                    parentColumns = "id",
                    childColumns = "product_id",
                    onDelete = ForeignKey.CASCADE),
            @ForeignKey(entity = Order.class,
                    parentColumns = "id",
                    childColumns = "order_id",
                    onDelete = ForeignKey.CASCADE)
        },
        indices = {
                @Index(value = "product_id"),
                @Index(value = "order_id")
        })
public class OrderDetail {
    public int product_id;
    public int order_id;
}
