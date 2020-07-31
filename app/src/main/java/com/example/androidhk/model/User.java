package com.example.androidhk.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class User {
String username;
String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        boolean a= getUsername().equals(user.getUsername());
        boolean b=  getPassword().equals(user.getPassword());
        return a && b;

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }
}
