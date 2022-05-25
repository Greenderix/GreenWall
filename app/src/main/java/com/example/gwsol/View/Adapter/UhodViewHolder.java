package com.example.gwsol.View.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gwsol.databinding.SingleRowBinding;
import com.example.gwsol.databinding.SingleRowUhodBinding;

public class UhodViewHolder extends RecyclerView.ViewHolder{
    ImageView plantImage;
    TextView plantHeader;
    TextView plantDescription;
    View plantLayout;

    public UhodViewHolder(SingleRowUhodBinding binding) {
        super(binding.getRoot());
        plantImage = binding.img1;
        plantHeader = binding.t1;
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
