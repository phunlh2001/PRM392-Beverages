package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.phunlh2001.prm392_beverages.data.entities.enums.OrderStatus;
import com.phunlh2001.prm392_beverages.data.entities.enums.OrderType;

import java.util.Date;

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
    private OrderType type;
    private OrderStatus status;
    private int user_id;
    @ColumnInfo(name = "createAt", defaultValue = "(datetime('now', 'localtime'))")
    private Date createAt;

    public Order(double total_price, OrderType type, OrderStatus status, int user_id) {
        this.total_price = total_price;
        this.type = type;
        this.status = status;
        this.user_id = user_id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        if (status == null) {
            this.status = OrderStatus.PREPARING;
        } else {
            this.status = status;
        }
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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

    public OrderType getShip_type() {
        return type;
    }

    public void setShip_type(OrderType type) {
        if (type != null)
            this.type = type;
        else
            this.type = OrderType.DELIVERY;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }
}
