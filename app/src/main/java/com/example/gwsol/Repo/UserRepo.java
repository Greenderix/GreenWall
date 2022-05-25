package com.example.gwsol.Repo;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.gwsol.Model.User;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class UserRepo {
    public List<User> users = new ArrayList<>();
    private MutableLiveData<User> currentUser = new MutableLiveData<>();
    public UserRepo(){
        User user = new User();
        user.setFirstName("Evgeny");
        user.setPassword("12345");
        users.add(user);
        User user1 = new User();
        user1.setFirstName("а");
        user1.setPassword("а");
        users.add(user1);
    }
   public MutableLiveData<Boolean> checkUser(String name, String password){
        for (User user: users){
            if (user.getFirstName().equals(name) && user.getPassword().equals(password)){
                currentUser.setValue(user);
                return new MutableLiveData<>(true);
            }
        }
        return new MutableLiveData<>(false);
   }
   public MutableLiveData<User> getCurrentUser(){
        return currentUser;
   }


}
