//package com.example.gwsol;
//
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//
//import com.example.gwsol.View.Fragments.Page_Profile;
//import com.example.gwsol.View.Fragments.Page_lentaFragment;
//import com.example.gwsol.View.Fragments.Page_uhod;
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//
//public class AppActivity extends AppCompatActivity {
//    BottomNavigationView bottomNavigationView;
//    Page_uhod page_uhod = new Page_uhod();
//    Page_Profile page_profile = new Page_Profile();
//    Page_lentaFragment lentaFragment = new Page_lentaFragment();
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.page_lenta);
//
//        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        getSupportFragmentManager().beginTransaction().replace(R.id.homefr, new Page_lentaFragment()).commit();
//
//        bottomNavigationView.setOnItemSelectedListener(item -> {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.uhod:
//                    selectedFragment = page_uhod;
//                    break;
//                case R.id.profile:
//                    selectedFragment = page_profile;
//                    break;
//                case R.id.lenta:
//                    selectedFragment = lentaFragment;
//                    break;
//
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.homefr, selectedFragment).commit();
//            return true;
//        });
//    }
//}
