package com.example.gwsol.View.Fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.gwsol.ViewModel.PlantViewModel;
import com.example.gwsol.databinding.AddnewnewBinding;
import com.example.gwsol.databinding.AddnewplantBinding;
import com.example.gwsol.databinding.ProfilePageBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class AddNewPlantFragment extends Fragment {
    AddnewnewBinding binding;
    PlantViewModel mViewModel;
    private ArrayList<String> planttypes = new ArrayList<String>(Arrays.asList(new String[]{
            "Домашние", "Кустовые", "Овощные"
    }));
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = AddnewnewBinding.inflate(inflater,container,false);

        View v = binding.getRoot();

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(PlantViewModel.class);
        binding.plantname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.setNewPlantName(s.toString());
            }
        });
        mViewModel.getNewPlantName().observe(getViewLifecycleOwner(),result->{
            if (!result.isEmpty()){
                binding.SelectType.setEnabled(true);
            }else{
                binding.SelectType.setEnabled(false);
            }
        });
        binding.SelectType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mViewModel.getNewPlantName().getValue();
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Выберите тип растения")
                        .setItems(planttypes.toArray(new String[0]), new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                               mViewModel.addNewPlant(name, which);
                                getParentFragmentManager().beginTransaction()
                                        .replace(R.id.main_fragment, new PageSuccessAdd()).addToBackStack(null).commit();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
