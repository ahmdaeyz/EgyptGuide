package dev.ahmdaeyz.egyptguide.ui.guide.churches;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;
import dev.ahmdaeyz.egyptguide.data.entities.LocationType;
import dev.ahmdaeyz.egyptguide.databinding.FragmentChurchesBinding;
import dev.ahmdaeyz.egyptguide.navigation.NavigateFrom;
import dev.ahmdaeyz.egyptguide.ui.common.LocationsListAdapter;
import dev.ahmdaeyz.egyptguide.ui.common.OnItemClickListener;

import static dev.ahmdaeyz.egyptguide.ui.MainActivity.mainLocation;


public class ChurchesFragment extends Fragment {
    private FragmentChurchesBinding binding;
    private NavigateFrom.Guide navigateFromGuide;

    public ChurchesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            navigateFromGuide = (NavigateFrom.Guide) context;
        } catch (ClassCastException e) {
            Log.e("ChurchesFragment", "You must implement NavigateFrom.Guide");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentChurchesBinding.inflate(inflater, container, false);
//        Egypt mainLocation = Egypt.getInstance();
        LocationsListAdapter adapter = new LocationsListAdapter();
        adapter.addAll(
                mainLocation.getLocationsOfType(LocationType.CHURCHES)
        );

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull GuideLocation location, @NonNull View view) {
                navigateFromGuide.toLocation(location);
            }
        });
        binding.churchesList.setAdapter(adapter);
        return binding.getRoot();
    }
}
