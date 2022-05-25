//package com.example.gwsol.View.Fragments;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.GridLayoutManager;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.gwsol.Model.Plant;
//import com.example.gwsol.R;
//import com.example.gwsol.View.Adapter.PlantAdapter;
//import com.example.gwsol.ViewModel.PlantsVM;
//import com.example.gwsol.databinding.PageLentaBinding;
//
//import java.util.ArrayList;
//
////
////public class Page_lentaFragment extends Fragment {
////
////    PlantAdapter adapter;
////    PlantsVM mViewModel;
////    RecyclerView rcv;
////
////    public static Page_lentaFragment newInstance() {
////        return new Page_lentaFragment();
////    }
////
////    @Override
////    public void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////    }
////
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        View view = inflater.inflate(R.layout.page_lenta, container, false);
////
////        mViewModel = new ViewModelProvider(this).get(PlantsVM.class);
////        final Observer<ArrayList<Plant>> nameObserver = new Observer<ArrayList<Plant>>() {
////            @Override
////            public void onChanged(@Nullable final ArrayList<Plant> plants) {
////                adapter = new PlantAdapter(plants,requireContext());
////                rcv.setAdapter(adapter);
////            }
////        };
////        rcv = view.findViewById(R.id.recview);
////        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
////        mViewModel.getCurrentName().observe(getViewLifecycleOwner(), nameObserver);
////        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
////        rcv.setLayoutManager(gridLayoutManager);
////
////        return view;
////    }
////}
//
//public class Page_lentaFragment extends Fragment {
//
////    PlantAdapter adapter;
////    PlantsVM mViewModel;
////    RecyclerView rcv;
//
//    private PlantsVM mViewModel;
//    PageLentaBinding binding;
//    private PlantAdapter mAdapter;
//
//    public static Page_lentaFragment newInstance() {
//        return new Page_lentaFragment();
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
////    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        View view = inflater.inflate(R.layout.page_lenta, container, false);
////
////        mViewModel = new ViewModelProvider(this).get(PlantsVM.class);
////        final Observer<ArrayList<Plant>> nameObserver = new Observer<ArrayList<Plant>>() {
////            @Override
////            public void onChanged(@Nullable final ArrayList<Plant> plants) {
////                adapter = new PlantAdapter(plants,requireContext());
////                rcv.setAdapter(adapter);
////            }
////        };
////        rcv = view.findViewById(R.id.recview);
////        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
////        mViewModel.getCurrentName().observe(getViewLifecycleOwner(), nameObserver);
////        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
////        rcv.setLayoutManager(gridLayoutManager);
////        return view;
////    }
//
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        binding = PageLentaBinding.inflate(inflater, container, false);
//        View v = binding.getRoot();
//
//        binding.recview.setLayoutManager(new GridLayoutManager(getContext(), 2));
//
//        return v;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
////        mViewModel = new ViewModelProvider(requireActivity()).get(PlantsVM.class);
////
////        mViewModel.getCurrentName().observe(getViewLifecycleOwner(), plants -> {
////            mAdapter = new PlantAdapter(this, plants, new PlantOnClickListener() {
////
////                @Override
////
////                public void onCLick(Plant plant) {
////
////                    int id = plant.getId();
////                    //mViewModel.se(course);
//////                    mViewModel.getCurrentName().getValue().get() //NEW 20 MAY
////                    getParentFragmentManager().beginTransaction().replace(R.id.homefr, new Page_lenta_infoFragment(id))
////                            .addToBackStack(null)
////                            .commit();
////                }
////            });
////            binding.recview.setAdapter(mAdapter);
////        });
//        mViewModel = new ViewModelProvider(requireActivity()).get(PlantsVM.class);
//        mViewModel.getplanlist().observe(getViewLifecycleOwner(),result->{
//            mAdapter = new PlantAdapter(this, (ArrayList<Plant>) result, new PlantOnClickListener() {
//                @Override
//                public void onCLick(Plant plant) {
//                    mViewModel.setCurrentName(plant);
//
//                    getParentFragmentManager().beginTransaction().replace(R.id.homefr, new Page_lenta_infoFragment())
//                            .addToBackStack(null)
//                            .commit();
//                }
//
//
//
//            });
//            binding.recview.setAdapter(mAdapter);
//        });
//    }
//}
