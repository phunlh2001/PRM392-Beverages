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
    private int quantity_product;
    private double totalItemPrice;
    public OrderDetail() {
    }

    public OrderDetail(int quantity_product, double totalItemPrice) {
        this.quantity_product = quantity_product;
        this.totalItemPrice = totalItemPrice;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public double getTotalItemPrice() {
        return totalItemPrice;
    }

    public void setTotalItemPrice(double totalItemPrice) {
        this.totalItemPrice = totalItemPrice;
    }
}
