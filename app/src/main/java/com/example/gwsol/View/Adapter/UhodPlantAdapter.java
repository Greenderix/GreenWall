package com.example.gwsol.View.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gwsol.Model.Uhod;
import com.example.gwsol.View.Fragments.Page_uhod;
import com.example.gwsol.databinding.SingleRowUhodBinding;

import java.util.ArrayList;
import java.util.List;

public class UhodPlantAdapter extends RecyclerView.Adapter<UhodViewHolder> {
    private Page_uhod mFragment;
    private List<Uhod> mUhods = new ArrayList<>();
    private UhodListener mCallback;


    public UhodPlantAdapter(Page_uhod fragment, List<Uhod> uhods, UhodListener callback) {
        mFragment = fragment;
        mUhods = uhods;
        mCallback = callback;
    }

    @NonNull
    @Override
    public UhodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SingleRowUhodBinding binding = SingleRowUhodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new UhodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UhodViewHolder holder, int position) {


        Uhod uhod = mUhods.get(position);

        holder.getPlantImage().setImageResource(uhod.getImgname());
        holder.getPlantHeader().setText(uhod.getHeader());

        holder.getPlantLayout().setOnClickListener(view -> mCallback.onClick(uhod));
    }

    @Override
    public int getItemCount() {
        return mUhods.size();
    }
}
