package com.example.gwsol.View.Fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.gwsol.Model.Plant;
import com.example.gwsol.R;
import com.example.gwsol.View.Adapter.PlantAdapter;
import com.example.gwsol.View.Adapter.PlantListener;
import com.example.gwsol.ViewModel.PlantViewModel;
import com.example.gwsol.databinding.PageLentaBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LentaPageFragment extends Fragment {
    private PageLentaBinding binding;
    private PlantViewModel mViewModel;

    private String uhodTag = "uhodTag";
    private String profileTag = "profileTag";
    private String lentaTag = "lentaTag";
    private String lentainfoTag = "lentainfoTag";
    BottomNavigationView bottomNavigationView;

    private PlantAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PageLentaBinding.inflate(inflater, container, false);
        binding.recview.setLayoutManager(new GridLayoutManager(getContext(),2));
        View view = binding.getRoot();
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        return true;
                    }
                }
                return false;
            }
        });
        return view;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(PlantViewModel.class);
//        mViewModel = new ViewModelProvider(requireActivity()).get(PlantViewModel.class);


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.uhod:
                     Page_uhod page_uhod = (Page_uhod) getParentFragmentManager().findFragmentByTag(uhodTag);
                    if (page_uhod == null) {
                        page_uhod = new Page_uhod();
                    }
                    getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, page_uhod, uhodTag)
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.profile:
                    Page_Profile page_profile = (Page_Profile) getParentFragmentManager().findFragmentByTag(profileTag);
                    if (page_profile == null) {
                        page_profile = new Page_Profile();
                    }
                    getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, page_profile, profileTag)
                            .addToBackStack(null)
                            .commit();
                    break;
                case R.id.lenta:
                    LentaPageFragment lentaPageFragment = (LentaPageFragment) getParentFragmentManager().findFragmentByTag(lentaTag);
                    if (lentaPageFragment == null) {
                        lentaPageFragment = new LentaPageFragment();
                    }
                    getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, lentaPageFragment, lentaTag)
                            .addToBackStack(null)
                            .commit();
                    break;

            }


            return true;
        });
        mViewModel.getPlants().observe(getViewLifecycleOwner(), result->{
            mAdapter = new PlantAdapter(this, result, new PlantListener() {


                @Override
                public void onClick(Plant plant) {
                    mViewModel.setCurrentPlant(plant);
                    LentaInfoPageFragment lentaInfoPageFragment = (LentaInfoPageFragment) getParentFragmentManager().findFragmentByTag(lentainfoTag);
                    if (lentaInfoPageFragment == null) {
                        lentaInfoPageFragment = new LentaInfoPageFragment();
                    }
                    getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, lentaInfoPageFragment ,lentainfoTag)
                            .addToBackStack(null)
                            .commit();
                }

                


            });
            binding.recview.setAdapter(mAdapter);

            int count = mAdapter.getItemCount();
            String textCount = "";
            if (count == 0  | count >= 5){
                textCount = String.valueOf(count)+" Растений";
            } else if (count == 1){
                textCount = String.valueOf(count)+" Растение";
            } else if ( count >= 2 && count <=4) {
                textCount = String.valueOf(count)+" Растения";
            } else {
                textCount = String.valueOf(count)+" Растения!!!!";
            }

            binding.textCount.setText(textCount);
        });

    }

    //        binding.recommendation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getParentFragmentManager().beginTransaction()
//                    .replace(R.id.main_fragment, new RegFirstName()).addToBackStack(null).commit();
//            }
//        });

}
