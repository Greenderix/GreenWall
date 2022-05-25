package com.example.gwsol.View.Fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gwsol.R;

import com.example.gwsol.ViewModel.PageRegViewModel;
import com.example.gwsol.ViewModel.UserViewModel;
import com.example.gwsol.databinding.FragmentPageRegBinding;

public class Page_regFragment extends Fragment {




    FragmentPageRegBinding binding;
    private UserViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentPageRegBinding.inflate(inflater, container, false);

        View v = binding.getRoot();
        return v;

        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        mViewModel.getFirstName().observe(getViewLifecycleOwner(), firstName->{
            if (!firstName.isEmpty()){
                binding.buttonNextpagePlants.setEnabled(true);
            }
            else {
                binding.buttonNextpagePlants.setEnabled(false);
            }
        });

        binding.firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mViewModel.setFirstName(editable.toString());
            }
        });

        binding.buttonNextpagePlants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
//                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activ, new Page_lentaFragment()).commit();
                        .replace(R.id.main_fragment, new Page_passwordFragment()).addToBackStack(null).commit();
            }
        });



    }
}
//    private PageRegViewModel mViewModel;
//
//    public static Page_regFragment newInstance() {
//        return new Page_regFragment();
//    }
//
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_page_reg, container, false);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(PageRegViewModel.class);
//        // TODO: Use the ViewModel
//    }