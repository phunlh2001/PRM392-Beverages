package com.phunlh2001.prm392_beverages.data.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "products",
        foreignKeys = @ForeignKey(
                entity = Product.class, parentColumns = "id", childColumns = "category_id", onDelete = 1),
        indices = @Index(value = "category_id"))
public class Product implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] thumbnail;
    private String title;
    @ColumnInfo(name = "description")
    private String desc;
    private double discount, price;
    private int category_id;

    public Product(int id, byte[] thumbnail, String title, String desc, double discount, double price, int category_id) {
        this.id = id;
        this.thumbnail = thumbnail;
        this.title = title;
        this.desc = desc;
        this.discount = discount;
        this.price = price;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
