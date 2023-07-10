package com.phunlh2001.prm392_beverages.data.entities;

import androidx.annotation.NonNull;
        import androidx.room.ColumnInfo;
        import androidx.room.Entity;
        import androidx.room.PrimaryKey;

        import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String email, username, password, full_name;
    @ColumnInfo(name = "avatar", defaultValue = "blank_avatar.jpg")
    private String avatar;
    private RoleAccount role;

    public User(String email, String username, String password) {
        this.email = this.email;
        this.username = this.username;
        this.password = this.password;
        this.full_name = full_name;
        this.avatar = avatar;
        this.role = role;
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
