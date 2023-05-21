package com.example.gwsol.View.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gwsol.databinding.SingleRowBinding;

public class PlantviewHolder extends RecyclerView.ViewHolder {
    ImageView plantImage;
    TextView plantHeader;
    TextView plantDescription;
    View plantLayout;

    public PlantviewHolder(SingleRowBinding binding) {
        super(binding.getRoot());
        plantImage = binding.img1;
        plantHeader = binding.t1;
        plantDescription = binding.t2;
        plantLayout = binding.plantCard;
    }

    public ImageView getPlantImage() {
        return plantImage;
    }

    public TextView getPlantHeader() {
        return plantHeader;
    }

    public TextView getPlantDescription() {
        return plantDescription;
    }

    public View getPlantLayout() {
        return plantLayout;
    }
}
