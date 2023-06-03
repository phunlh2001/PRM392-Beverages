package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

enum ShipTypes {
    Delivery, Store_Pickup
}

@Entity(tableName = "orders",
        foreignKeys = @ForeignKey(
                entity = Order.class, parentColumns = "id", childColumns = "user_id", onDelete = 1),
        indices = @Index(value = "user_id"))
public class Order {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private double total_price;
    private int quantity_product;
    private ShipTypes ship_type;
    private int user_id;

    public Order(int id, double total_price, int quantity_product, ShipTypes ship_type, int user_id) {
        this.id = id;
        this.total_price = total_price;
        this.quantity_product = quantity_product;
        this.ship_type = ship_type;
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ShipTypes getShip_type() {
        return ship_type;
    }

    public void setShip_type(ShipTypes ship_type) {
        if (ship_type != null)
            this.ship_type = ship_type;
        else
            this.ship_type = ShipTypes.Delivery;
    }
}
