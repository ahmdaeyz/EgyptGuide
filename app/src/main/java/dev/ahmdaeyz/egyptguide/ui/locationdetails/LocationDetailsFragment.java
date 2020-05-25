package dev.ahmdaeyz.egyptguide.ui.locationdetails;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.parceler.Parcels;

import dev.ahmdaeyz.egyptguide.data.entities.Egypt;
import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;
import dev.ahmdaeyz.egyptguide.databinding.FragmentLocationDetailsBinding;
import dev.ahmdaeyz.egyptguide.navigation.NavigateFrom;

public class LocationDetailsFragment extends Fragment {
    private static final String ARG_LOCATION = "location";
    private FragmentLocationDetailsBinding binding;
    private NavigateFrom.Location navigateFromLocation;
    private GuideLocation location;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            navigateFromLocation = (NavigateFrom.Location) context;
        }catch (ClassCastException e){
            Log.e("LocationDetailsFragment","You must implement NavigateFrom.Location");
        }
    }

    public LocationDetailsFragment() {
        // Required empty public constructor
    }


    public static LocationDetailsFragment newInstance(GuideLocation location) {
        LocationDetailsFragment fragment = new LocationDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_LOCATION, Parcels.wrap(location));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            location = Parcels.unwrap(getArguments().getParcelable(ARG_LOCATION));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationDetailsBinding.inflate(inflater,container,false);
        binding.toolBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateFromLocation.toGuide();
            }
        });
        bindDetails();
        return binding.getRoot();
    }

    private void bindDetails() {
        binding.toolBar.setTitle(location.getName());
        binding.toolBar.setSubtitle(location.getExactLocation());
        binding.locationDetails.setText(location.getDescription());
        Glide
                .with(binding.locationImage)
                .load(Egypt.getDrawables().get(location.getName()))
                .into(binding.locationImage);

    }


}
