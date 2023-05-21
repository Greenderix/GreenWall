package com.example.gwsol.View.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gwsol.Model.Plant;
import com.example.gwsol.View.Fragments.LentaPageFragment;

import com.example.gwsol.databinding.SingleRowBinding;

import java.util.ArrayList;
import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantviewHolder> {


    private LentaPageFragment mFragment;
    private List<Plant> mPlants = new ArrayList<>();
    private PlantListener mCallback;


    public PlantAdapter(LentaPageFragment fragment, List<Plant> plants, PlantListener callback) {
        mFragment = fragment;
        mPlants = plants;
        mCallback = callback;
    }

    @NonNull
    @Override
    public PlantviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleRowBinding binding = SingleRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PlantviewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PlantviewHolder holder, int position) {


        Plant plant = mPlants.get(position);

        holder.getPlantImage().setImageResource(plant.getImgname());
        holder.getPlantHeader().setText(plant.getHeader());
        holder.getPlantDescription().setText(plant.getDesc());
        holder.getPlantLayout().setOnClickListener(view -> mCallback.onClick(plant));
    }

    @Override
    public int getItemCount() {
        return mPlants.size();
    }
}
