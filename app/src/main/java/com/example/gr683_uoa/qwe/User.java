package com.example.gr683_uoa.qwe;

import android.util.Log;

public class User {
    public String name;
    public String date;
    public String phone;
    public Integer id;

    public User(String name, String date, String phone, Integer id) {
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        Log.e("aaa","aaaaaa"+name.toString());
        return name;
    }

    public String getDate() {
        Log.e("aaa","aaaaaa"+date.toString());
        return date;
    }

    public String getPhone() {
        Log.e("aaa","aaaaaa"+phone.toString());
        return phone;
    }

    public Integer getId() {
        Log.e("aaa","aaaaaa"+id.toString());
        return id;
    }
}
