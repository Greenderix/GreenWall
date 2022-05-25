package com.example.gwsol.Repo;

import com.example.gwsol.Model.Plant;
import com.example.gwsol.Model.Uhod;
import com.example.gwsol.R;

import java.util.ArrayList;
import java.util.List;

public class UhodRepository {
    private List<Uhod> uhods= new ArrayList<>();

    public UhodRepository() {
        Uhod uhod = new Uhod();
        uhod.setHeader("Домашние");
        uhod.setDesc("У данного типа цветов есть особенность, которая заключается в частом уходе и поливании цветов, такие цветы любят воду.");
        uhod.setImgname(R.drawable.pl_6_zamiokulkas);
        uhods.add(uhod);

        Uhod uhod1 = new Uhod();
        uhod1.setHeader("Кустовые");
        uhod1.setDesc("Кустовым цветам необходимо употреблять большое количетсво воды, но раз в неделю. Эти цветы не привередливы в поливании и ухаживании");
        uhod1.setImgname(R.drawable.pl_8_roza);
        uhods.add(uhod1);

        Uhod uhod2 = new Uhod();
        uhod2.setHeader("Овощные");
        uhod2.setDesc("Цветы - овощи очень трепетны в своем уходи, им нужно поддерживать постоянную влажность на протяжении всех дней, чтобы они могли расти.");
        uhod2.setImgname(R.drawable.pl_9_pomidor);
        uhods.add(uhod2);

    }
    public List<Uhod> getUhods(){
        return uhods;
    }
}
