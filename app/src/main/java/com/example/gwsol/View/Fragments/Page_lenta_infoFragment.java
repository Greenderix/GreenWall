//package com.example.gwsol.View.Fragments;
//
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.example.gwsol.R;
//import com.example.gwsol.ViewModel.PlantsVM;
//import com.example.gwsol.databinding.PageLentaInfoBinding;
//
//public class Page_lenta_infoFragment extends Fragment {
////    int id;
////    Page_lenta_infoFragment (int id){
////        this.id = id;
////    }
//
//
////    ImageView img;
////    TextView tv1,tv2;
////    @Override
////    protected void onCreate(Bundle savedInstanceState)
////    {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main2);
////
////        img=(ImageView)findViewById(R.id.desc_img);
////        tv1=(TextView)findViewById(R.id.desc_header);
////        tv2=(TextView)findViewById(R.id.desc_desc);
////
////        img.setImageResource(getIntent().getIntExtra("imagename",0));
////        tv1.setText(getIntent().getStringExtra("header"));
////        tv2.setText(getIntent().getStringExtra("desc"));
////    }
//
//    private PlantsVM mViewModel;
//    PageLentaInfoBinding binding;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        binding = PageLentaInfoBinding.inflate(inflater, container, false);
//        View v = binding.getRoot();
//
//        return v;
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        mViewModel = new ViewModelProvider(requireActivity()).get(PlantsVM.class);
//
//        binding.imageView9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                getParentFragmentManager().beginTransaction().replace(R.id.homefr, new Page_lentaFragment())
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });
//
////        binding.descImg1.setImageResource(mViewModel.getCurrentName().getValue().get(id).getImgname());
////        binding.descHeader1.setText(mViewModel.getCurrentName().getValue().get(id).getHeader());
////        binding.descDesc1.setText(mViewModel.getCurrentName().getValue().get(id).getDesc());
//
//        mViewModel.getCurrentName().observe(getViewLifecycleOwner(), result -> {
//
//            binding.descImg1.setImageResource(result.getImgname());
//            binding.descHeader1.setText(result.getHeader());
//            binding.descDesc1.setText(result.getDesc());
//        });
//
////        mViewModel.getCurrentName().observe(getViewLifecycleOwner(), result -> {
////
////            binding.descImg1.setImageResource(mViewModel.getCurrentName().getValue().get().getImgname());
////            binding.eventDesc.setText(result.getDescription());
////            binding.addressText.setText(result.getAddress());
////            binding.timeText.setText(result.getTimeOfEvent().toString());
////            binding.firstDateText.setText(result.getStartDate().getTime().toString());
////            binding.secondDateText.setText(result.getFinalDate().getTime().toString());
////            binding.siteText.setText(result.getEventLink());
////        });
//
//    }
//}
