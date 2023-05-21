package com.example.gwsol.View.Fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.gwsol.R;
import com.example.gwsol.ViewModel.UserViewModel;
import com.example.gwsol.databinding.PagePasswordBinding;

public class Page_passwordFragment extends Fragment {
    PagePasswordBinding binding;
    private UserViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = PagePasswordBinding.inflate(inflater, container, false);

        View v = binding.getRoot();
        return v;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);


        binding.password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mViewModel.setPassword(editable.toString());
                binding.passwordLayout.setError(null);
            }
        });

        binding.buttonnextpge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mViewModel.getFirstName().getValue();
                String password = mViewModel.getPassword().getValue();
                mViewModel.checkUser(name, password).observe(getViewLifecycleOwner(), result -> {
                    if (Boolean.TRUE.equals(result)) {
                        getParentFragmentManager().beginTransaction()
                                .replace(R.id.main_fragment, new LentaPageFragment()).addToBackStack(null).commit();
                    } else {
                        binding.passwordLayout.setError("Неверно введены данные :с");
                    }
                });

            }
        });


    }
}
