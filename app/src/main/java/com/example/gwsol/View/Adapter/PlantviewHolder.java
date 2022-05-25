package com.example.gwsol.View.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gwsol.Model.Plant;
import com.example.gwsol.R;
import com.example.gwsol.databinding.SingleRowBinding;

public class PlantviewHolder extends RecyclerView.ViewHolder{
//    ImageView img;
//    TextView t1,t2;
//    public PlantviewHolder(@NonNull View itemView)
//    {
//        super(itemView);
//        img=(ImageView)itemView.findViewById(R.id.img1);
//        t1=(TextView)itemView.findViewById(R.id.t1);
//        t2=(TextView)itemView.findViewById(R.id.t2);
//    }
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
