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

import com.example.gwsol.Model.Uhod;
import com.example.gwsol.R;
import com.example.gwsol.View.Adapter.UhodListener;
import com.example.gwsol.View.Adapter.UhodPlantAdapter;
import com.example.gwsol.ViewModel.UhodViewModel;
import com.example.gwsol.databinding.UhodPageBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Page_uhod extends Fragment {
    private UhodPageBinding binding;
    private UhodViewModel mViewModel;

    private String uhodTag = "uhodTag";
    private String profileTag = "profileTag";
    private String lentaTag = "lentaTag";
    private String uhodinfoTag = "uhodinfoTag";
    BottomNavigationView bottomNavigationView;

    private UhodPlantAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = UhodPageBinding.inflate(inflater, container, false);
        binding.recview.setLayoutManager(new GridLayoutManager(getContext(), 2));
        View view = binding.getRoot();

        return view;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(UhodViewModel.class);


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
        mViewModel.getUhods().observe(getViewLifecycleOwner(), result -> {
            mAdapter = new UhodPlantAdapter(this, result, new UhodListener() {


                @Override
                public void onClick(Uhod uhod) {
                    mViewModel.setCurrentUhod(uhod);
                    UhodInfoFragment uhodInfoFragment = (UhodInfoFragment) getParentFragmentManager().findFragmentByTag(uhodinfoTag);
                    if (uhodInfoFragment == null) {
                        uhodInfoFragment = new UhodInfoFragment();
                    }
                    getParentFragmentManager().beginTransaction().replace(R.id.main_fragment, uhodInfoFragment, uhodinfoTag)
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
