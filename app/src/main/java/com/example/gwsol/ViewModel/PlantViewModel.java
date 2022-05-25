package com.example.gwsol.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gwsol.DI.ServiceLocator;
import com.example.gwsol.Model.Plant;
import com.example.gwsol.Model.User;
import com.example.gwsol.Repo.PlantRepository;
import com.example.gwsol.Repo.UhodRepository;
import com.example.gwsol.Repo.UserRepo;

import java.util.List;

public class PlantViewModel extends AndroidViewModel {
    private PlantRepository mRepository;
    private UserRepo mRepoUser;
    private UhodRepository mRepoUhod;

    MutableLiveData<Plant> currentPlant = new MutableLiveData<>();
    MutableLiveData<String> newPlantName = new MutableLiveData<>("");
    MutableLiveData<Plant> newPlant = new MutableLiveData<>();




    public PlantViewModel(@NonNull Application application) {
        super(application);
        mRepository = ServiceLocator.getInstance().getPlantRepository();
        mRepoUser = ServiceLocator.getInstance().getRepository();

    }


    public MutableLiveData<List<Plant>> getPlants(){
        return new MutableLiveData<>(mRepository.getPlants());
    }

    public MutableLiveData<Plant> getCurrentPlant() {
        return currentPlant;
    }

    public void setCurrentPlant(Plant plant) {
        currentPlant.setValue(plant);
    }

    public  MutableLiveData<String> getNewPlantName(){return newPlantName;}
    public void setNewPlantName(String name){newPlantName.setValue(name);}

    public void addNewPlant(String name, int type){
        User user = mRepoUser.getCurrentUser().getValue();
        String desc = "Выращивает " + user.getFirstName();
        Plant plant = mRepository.addPlant(name, desc, type);
        newPlant.setValue(plant);

    }
    public String getUsername(){
        return mRepoUser.getCurrentUser().getValue().getFirstName();
    }

    public MutableLiveData<Plant> getNewPlant() {
        return newPlant;
    }
}

