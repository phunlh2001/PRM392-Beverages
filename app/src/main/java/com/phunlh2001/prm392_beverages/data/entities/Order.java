package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.phunlh2001.prm392_beverages.data.entities.enums.OrderType;

@Entity(tableName = "Orders",
        foreignKeys = @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "user_id",
                onDelete = ForeignKey.CASCADE),
        indices = @Index(value = "user_id"))
public class Order {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double total_price;
    private int quantity_product;
    private OrderType ship_type;
    private int user_id;

    public Order(double total_price, int quantity_product, OrderType ship_type, int user_id) {
        this.total_price = total_price;
        this.quantity_product = quantity_product;
        this.ship_type = ship_type;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getQuantity_product() {
        return quantity_product;
    }

    public void setQuantity_product(int quantity_product) {
        this.quantity_product = quantity_product;
    }

    public OrderType getShip_type() {
        return ship_type;
    }

    public void setShip_type(OrderType ship_type) {
        if (ship_type != null)
            this.ship_type = ship_type;
        else
            this.ship_type = OrderType.DELIVERY;
    }
}
