package com.example.gwsol.Repo;

import com.example.gwsol.Model.Plant;
import com.example.gwsol.R;


import java.util.ArrayList;

import java.util.List;

public class PlantRepository {
    private List<Plant> plants = new ArrayList<>();

    public PlantRepository() {
        Plant plant = new Plant();

       
        plant.getId();
        plant.setHeader("Аглаонема");
        plant.setDesc("Выращивает Никита");
        plant.setImgname(R.drawable.plagl);
        plant.setIsMine(false);
        plants.add(plant);

        Plant plant1=new Plant();
        plant1.getId();
        plant1.setHeader("Бонсай");
        plant1.setDesc("Выращивает Борис");
        plant1.setImgname(R.drawable.pl_2_bonsai);
        plant1.setIsMine(false);
        plants.add(plant1);

        Plant plant2=new Plant();
        plant2.setHeader("Фикус");
        plant2.setDesc("Выращивает Елизавета");
        plant2.setImgname(R.drawable.pl_3_fikus);
        plant2.setIsMine(false);
        plants.add(plant2);

        Plant plant3=new Plant();
        plant3.setHeader("Кактус");
        plant3.setDesc("Выращивает Максим");
        plant3.setImgname(R.drawable.pl_4_kaktus);
        plant3.setIsMine(false);
        plants.add(plant3);

        Plant plant4=new Plant();
        plant4.setHeader("Лимон");
        plant4.setDesc("Выращивает Полина");
        plant4.setImgname(R.drawable.pl_5_limon);
        plant4.setIsMine(false);
        plants.add(plant4);

        Plant plant5=new Plant();
        plant5.setHeader("Замиокулькас");
        plant5.setDesc("Выращивает Адиль");
        plant5.setImgname(R.drawable.pl_6_zamiokulkas);
        plant5.setIsMine(false);
        plants.add(plant5);

        Plant plant6=new Plant();
        plant6.setHeader("Самшит");
        plant6.setDesc("Выращивает Антон");
        plant6.setImgname(R.drawable.pl_7_samshit);
        plant6.setIsMine(false);
        plants.add(plant6);

        Plant plant7=new Plant();
        plant7.setHeader("Роза");
        plant7.setDesc("Выращивает Евгений");
        plant7.setImgname(R.drawable.pl_8_roza);
        plant7.setIsMine(false);
        plants.add(plant7);

        Plant plant8=new Plant();
        plant8.setHeader("Помидоры");
        plant8.setDesc("Выращивает Евгений");
        plant8.setImgname(R.drawable.pl_9_pomidor);
        plant8.setIsMine(false);
        plants.add(plant8);

        Plant plant9=new Plant();
        plant9.setHeader("Орхидея");
        plant9.setDesc("Выращивает Кирилл");
        plant9.setImgname(R.drawable.pl_10_orh);
        plant9.setIsMine(true);
        plants.add(plant9);
    }

    public List<Plant> getPlants(){
        return plants;
    }
    public Plant addPlant(String header, String desc, int type){
        Plant plant = new Plant();
        plant.setHeader(header);
        plant.setDesc(desc);
        //0 polevye
        if (type==0){
            plant.setImgname(R.drawable.pl_2_bonsai);
        } else if ( type == 1){
            plant.setImgname(R.drawable.pl_8_roza);
        }else if ( type == 2){
            plant.setImgname(R.drawable.pl_9_pomidor);
        }
        plant.setIsMine(true);
        plants.add(plant);
        return plant;
    }
}
