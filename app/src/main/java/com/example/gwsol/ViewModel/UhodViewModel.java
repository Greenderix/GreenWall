package com.example.gwsol.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.gwsol.DI.ServiceLocator;
import com.example.gwsol.Model.Uhod;
import com.example.gwsol.Model.Uhod;
import com.example.gwsol.Model.User;
import com.example.gwsol.Repo.UhodRepository;
import com.example.gwsol.Repo.UhodRepository;
import com.example.gwsol.Repo.UserRepo;

import java.util.List;


public class UhodViewModel extends AndroidViewModel {
       
        private UhodRepository mRepoUhod;

        MutableLiveData<Uhod> currentUhod = new MutableLiveData<>();
       




        public UhodViewModel(@NonNull Application application) {
            super(application);
           
            mRepoUhod = ServiceLocator.getInstance().getUhodRepository();
        }


        public MutableLiveData<List<Uhod>> getUhods(){
            return new MutableLiveData<>(mRepoUhod.getUhods());
        }

        public MutableLiveData<Uhod> getCurrentUhod() {
            return currentUhod;
        }

        public void setCurrentUhod(Uhod uhod) {
            currentUhod.setValue(uhod);
        }






}
