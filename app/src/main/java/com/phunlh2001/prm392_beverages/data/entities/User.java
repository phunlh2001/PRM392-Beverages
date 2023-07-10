package com.phunlh2001.prm392_beverages.data.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

import java.util.Date;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    private String email, password, full_name, address, phone_number;
    @ColumnInfo(name = "avatar", defaultValue = "'blank_avatar.jpg'")
    private String avatar;
    private RoleAccount role;
    @ColumnInfo(name = "createAt", defaultValue = "(datetime('now', 'localtime'))")
    private Date createAt;

    public User(@NonNull String email, @NonNull String password, @NonNull String full_name, @NonNull String address, @NonNull String phone_number, String avatar, RoleAccount role) {
        this.email = email;
        this.password = password;
        this.full_name = full_name;
        this.address = address;
        this.phone_number = phone_number;
        this.avatar = avatar;
        this.role = role;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(@NonNull String phone_number) {
        this.phone_number = phone_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
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
}
