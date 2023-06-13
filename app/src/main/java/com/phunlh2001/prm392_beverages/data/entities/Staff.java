package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.phunlh2001.prm392_beverages.data.entities.enums.RoleAccount;


@Entity(tableName = "staffs",
        foreignKeys = @ForeignKey(
            entity = Staff.class, parentColumns = "id", childColumns = "account_id", onDelete = 1),
        indices = @Index(value = "account_id"))
public class Staff extends Account {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String full_name;
    private int account_id;

    public Staff(String email, String username, String password, byte[] avatar, RoleAccount role, int id, String full_name, int account_id) {
        super(email, username, password, avatar, role);
        this.id = id;
        this.full_name = full_name;
        this.account_id = account_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
