package dev.ahmdaeyz.egyptguide.ui.guide.museums;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xwray.groupie.GroupAdapter;
import com.xwray.groupie.Item;
import com.xwray.groupie.OnItemClickListener;

import java.util.stream.Collectors;

import dev.ahmdaeyz.egyptguide.data.entities.Egypt;
import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;
import dev.ahmdaeyz.egyptguide.data.entities.LocationType;
import dev.ahmdaeyz.egyptguide.databinding.FragmentMusuemsBinding;
import dev.ahmdaeyz.egyptguide.navigation.NavigateFrom;
import dev.ahmdaeyz.egyptguide.ui.common.LocationItem;


public class MuseumsFragment extends Fragment {
    private FragmentMusuemsBinding binding;
    private NavigateFrom.Guide navigateFromGuide;

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            navigateFromGuide = (NavigateFrom.Guide) context;
        } catch (ClassCastException e) {
            Log.e("MuseumsFragment", "You must implement NavigateFrom.Guide");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMusuemsBinding.inflate(inflater, container, false);
        Egypt mainLocation = Egypt.getInstance();
        GroupAdapter adapter = new GroupAdapter();
        adapter.addAll(
                mainLocation.getLocationsOfType(LocationType.MUSEUMS)
                        .stream()
                        .map(GuideLocation.class::cast)
                        .map(LocationItem::new)
                        .collect(Collectors.toList())
        );
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull Item item, @NonNull View view) {
                LocationItem locationItem = (LocationItem) item;
                navigateFromGuide.toLocation(locationItem.getLocation());
            }
        });
        binding.museumsList.setAdapter(adapter);

        return binding.getRoot();
    }
}