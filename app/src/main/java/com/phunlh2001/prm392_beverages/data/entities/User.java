package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

@Entity(tableName = "users",
        foreignKeys = @ForeignKey(
                entity = User.class, parentColumns = "user_id", childColumns = "account_id", onDelete = 1),
        indices = @Index(value = "account_id"))
public class User extends Account {
    @PrimaryKey(autoGenerate = true)
    private int user_id;
    private String full_name;
    private double coupon;
    private int order_id, account_id;

    public User(String email, String username, String password, byte[] avatar, RoleAccount role, int user_id, String full_name, double coupon, int order_id, int account_id) {
        super(email, username, password, avatar, role);
        this.user_id = user_id;
        this.full_name = full_name;
        this.coupon = coupon;
        this.order_id = order_id;
        this.account_id = account_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
