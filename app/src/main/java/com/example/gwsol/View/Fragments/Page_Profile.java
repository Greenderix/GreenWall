package com.example.gwsol.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gwsol.Model.Plant;
import com.example.gwsol.R;
import com.example.gwsol.View.Adapter.MyPlantAdapter;
import com.example.gwsol.View.Adapter.PlantListener;
import com.example.gwsol.ViewModel.PlantViewModel;
import com.example.gwsol.databinding.ProfilePageBinding;


import java.util.ArrayList;
import java.util.stream.Collectors;

public class Page_Profile extends Fragment {
    ProfilePageBinding binding;
    MyPlantAdapter mAdapter;
    PlantViewModel mViewModel;
    private String profileinfoTag = "profileinfoTag";
    private String uhodTag = "uhodTag";
    private String profileTag = "profileTag";
    private String lentaTag = "lentaTag";
    RecyclerView rcv;

    public static LentaPageFragment newInstance() {
        return new LentaPageFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = ProfilePageBinding.inflate(inflater, container, false);

        View v = binding.getRoot();
        binding.recview.setLayoutManager(new GridLayoutManager(getContext(), 2));

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(PlantViewModel.class);
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
        binding.addbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment, new AddNewPlantFragment()).addToBackStack(null).commit();
            }
        });
        binding.profileDescpage.setText("Добавлено от Вас, " + mViewModel.getUsername());
        mViewModel.getPlants().observe(getViewLifecycleOwner(), result -> {
            mAdapter = new MyPlantAdapter(this, result.stream().filter(plant -> plant.getIsMine()).collect(Collectors.toList()), new PlantListener() {


                @Override
                public void onClick(Plant plant) {
                    mViewModel.setCurrentPlant(plant);
                    LentaInfoPageFragment lentaInfoPageFragment = (LentaInfoPageFragment) getParentFragmentManager().findFragmentByTag(profileinfoTag);
                    if (lentaInfoPageFragment == null) {
                        lentaInfoPageFragment = new LentaInfoPageFragment();
                    }
                    getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, lentaInfoPageFragment, profileinfoTag)
                            .addToBackStack(null)
                            .commit();
                }


            });

            binding.recview.setAdapter(mAdapter);
            int count = mAdapter.getItemCount();
            String textCount = "";
            if (count == 0 | count >= 5) {
                textCount = String.valueOf(count) + " Растений";
            } else if (count == 1) {
                textCount = String.valueOf(count) + " Растение";
            } else if (count >= 2 && count <= 4) {
                textCount = String.valueOf(count) + " Растения";
            } else {
                textCount = String.valueOf(count) + " Растения!!!!";
            }

            binding.textCount.setText(textCount);
        });
    }
}
