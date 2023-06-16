package com.phunlh2001.prm392_beverages.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String email, username, password;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] avatar;
    private RoleAccount role;
    @NonNull
    private String full_name;
    private double coupon;

    public User(int id, @NonNull String email, @NonNull String username, @NonNull String password, @NonNull byte[] avatar, RoleAccount role, @NonNull String full_name, double coupon) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
        this.full_name = full_name;
        this.coupon = coupon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(@NonNull byte[] avatar) {
        this.avatar = avatar;
    }

    public RoleAccount getRole() {
        return role;
    }

    public void setRole(RoleAccount role) {
        if (role == null) {
            this.role = RoleAccount.USER;
        } else {
            this.role = role;
        }
    }

    @NonNull
    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(@NonNull String full_name) {
        this.full_name = full_name;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }
}
