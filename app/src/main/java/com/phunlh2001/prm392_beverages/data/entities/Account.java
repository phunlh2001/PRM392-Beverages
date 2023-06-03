package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.ColumnInfo;

enum Role {
    Staff, User
}

public class Account {
    private String email, username, password;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] avatar;
    private Role role;

    public Account(String email, String username, String password, byte[] avatar, Role role) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (role == null) {
            this.role = Role.User;
        } else {
            this.role = role;
        }
    }
}
