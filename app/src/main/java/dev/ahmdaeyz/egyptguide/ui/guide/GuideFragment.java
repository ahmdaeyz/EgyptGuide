package dev.ahmdaeyz.egyptguide.ui.guide;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.ahmdaeyz.egyptguide.R;
import dev.ahmdaeyz.egyptguide.databinding.FragmentGuideBinding;


public class GuideFragment extends Fragment {
    private FragmentGuideBinding binding;

    public GuideFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGuideBinding.inflate(inflater,container,false);
        LocationsFragmentsPagerAdapter adapter = new LocationsFragmentsPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.POSITION_UNCHANGED);
        binding.viewPager.setAdapter(adapter);
        binding.tabs.setupWithViewPager(binding.viewPager);
        return binding.getRoot();
    }
}
