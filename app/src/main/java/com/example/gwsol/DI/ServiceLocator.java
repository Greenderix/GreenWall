package com.example.gwsol.DI;

import android.content.Context;

import com.example.gwsol.Repo.PlantRepository;
import com.example.gwsol.Repo.UhodRepository;
import com.example.gwsol.Repo.UserRepo;


public class ServiceLocator {

    private static ServiceLocator serviceLocator;

    private UserRepo usersRepository;

    private PlantRepository plantRepository;
    private UhodRepository uhodRepository;

    private Context context;

    private ServiceLocator(Context context) {
        serviceLocator = this;

        usersRepository = new UserRepo();
        plantRepository = new PlantRepository();
        uhodRepository = new UhodRepository();
    }



    public static ServiceLocator getInstance() {
        return serviceLocator;
    }

    public static void init (Context context){
        serviceLocator = new ServiceLocator(context);
    }

    public UserRepo getRepository() {
        return usersRepository;
    }

    public PlantRepository getPlantRepository(){
        return plantRepository;
    }
    public UhodRepository getUhodRepository(){
        return uhodRepository;
    }

}

