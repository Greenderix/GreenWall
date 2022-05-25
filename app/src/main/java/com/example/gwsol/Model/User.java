package com.example.gwsol.Model;

import androidx.annotation.NonNull;

import java.util.Calendar;

public class User {

    @NonNull
    private String firstName;
    private String password;

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }
    public String getPassword(){return password;}
    public void setPassword(@NonNull String password){this.password = password;}

}
