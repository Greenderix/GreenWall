//package com.example.gwsol.ViewModel;
//import android.app.Application;
//
//import androidx.annotation.NonNull;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.ViewModel;
//
//import com.example.gwsol.DI.ServiceLocator;
//import com.example.gwsol.Model.Plant;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
////public class PlantsVM extends ViewModel {
////
////    private MutableLiveData<ArrayList<Plant>> currentName;
////
////    public MutableLiveData<ArrayList<Plant>> getCurrentName() {
////
////        if (currentName == null) {
////            currentName = new MutableLiveData<ArrayList<Plant>>();
////        }
////        currentName.setValue(new PlantsRepo().getplantlist());
////        return currentName;
////    }
////    public Plant getIndex(int index) {
////            return getCurrentName().getValue().get(index);
////    }
////    }
//
//
//
//public class PlantsVM extends ViewModel {
//
//    private PlantsRepo mRepository;
//
//    MutableLiveData<Plant> currentName = new MutableLiveData<>();
//
//    public PlantsVM(@NonNull Application application) {
//
//        mRepository = ServiceLocator.getInstance().getmRepo();
//    }
//
//    public MutableLiveData<List<Plant>> getplanlist(){
//        return new MutableLiveData<>(mRepository.getplantlist());
//    }
//
//    public MutableLiveData<Plant> getCurrentName() {
//        return currentName;
//    }
//
//    public void setCurrentName(Plant plant) {
//        currentName.setValue(plant);
//    }
//}
//
//
