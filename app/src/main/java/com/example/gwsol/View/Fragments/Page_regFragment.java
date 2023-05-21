package com.example.gwsol.View.Fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gwsol.R;

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

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        mViewModel.getFirstName().observe(getViewLifecycleOwner(), firstName -> {
            if (!firstName.isEmpty()) {
                binding.buttonNextpagePlants.setEnabled(true);
            } else {
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
                        .replace(R.id.main_fragment, new Page_passwordFragment()).addToBackStack(null).commit();
            }
        });


    }
}