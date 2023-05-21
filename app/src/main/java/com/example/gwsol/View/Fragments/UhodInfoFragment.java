package com.example.gwsol.View.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gwsol.R;
import com.example.gwsol.ViewModel.UhodViewModel;
import com.example.gwsol.databinding.UhodinfoBinding;

public class UhodInfoFragment extends Fragment {
    UhodinfoBinding binding;
    private UhodViewModel mViewModel;
    private String uhodTag = "uhodTag";
    private String profileTag = "profileTag";
    private String lentaTag = "lentaTag";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = UhodinfoBinding.inflate(inflater, container, false);

        View v = binding.getRoot();

        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(UhodViewModel.class);
        binding.bttmnavig.setOnItemSelectedListener(item -> {
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
        mViewModel.getCurrentUhod().observe(getViewLifecycleOwner(), result -> {

            binding.descDesc11.setText(result.getDesc());
            binding.descHeader1.setText(result.getHeader());
            binding.descImg1.setImageResource(result.getImgname());

        });
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.main_fragment, new Page_uhod()).addToBackStack(null).commit();
            }
        });
    }
}
