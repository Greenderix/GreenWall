package com.example.gwsol;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.gwsol.DI.ServiceLocator;
import com.example.gwsol.View.Fragments.LentaPageFragment;
import com.example.gwsol.View.Fragments.Page_Profile;

import com.example.gwsol.View.Fragments.Page_regFragment;
import com.example.gwsol.View.Fragments.Page_uhod;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Page_uhod page_uhod = new Page_uhod();

    Page_Profile page_profile = new Page_Profile();
    LentaPageFragment lentaFragment = new LentaPageFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, new Page_regFragment()).addToBackStack(null).commit();
        ServiceLocator.init(this.getApplicationContext());
    }
}