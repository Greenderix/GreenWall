package com.example.gwsol.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gwsol.DI.ServiceLocator;
import com.example.gwsol.Repo.UserRepo;


public class UserViewModel extends AndroidViewModel {
    private UserRepo userRepo;
    private MutableLiveData<String> firstName = new MutableLiveData<>("");
    private MutableLiveData<String> password = new MutableLiveData<>("");
    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo = ServiceLocator.getInstance().getRepository();
    }
    public MutableLiveData<String> getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName.setValue(firstName);
    }


    public MutableLiveData<String> getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password.setValue(password);
    }
    public MutableLiveData<Boolean> checkUser(String name, String password){return userRepo.checkUser(name,password);}

}
