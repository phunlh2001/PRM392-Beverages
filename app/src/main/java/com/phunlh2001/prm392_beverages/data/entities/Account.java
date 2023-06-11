package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

import java.io.Serializable;

public class Account implements Serializable {
    private String email, username, password;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] avatar;
    private RoleAccount role;

    public Account(String email, String username, String password, byte[] avatar, RoleAccount role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
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
}
