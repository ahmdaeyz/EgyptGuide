package dev.ahmdaeyz.egyptguide.ui;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import dev.ahmdaeyz.egyptguide.R;
import dev.ahmdaeyz.egyptguide.data.entities.Egypt;
import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;
import dev.ahmdaeyz.egyptguide.databinding.ActivityMainBinding;
import dev.ahmdaeyz.egyptguide.navigation.NavigateFrom;
import dev.ahmdaeyz.egyptguide.ui.guide.GuideFragment;
import dev.ahmdaeyz.egyptguide.ui.locationdetails.LocationDetailsFragment;

public class MainActivity extends AppCompatActivity implements NavigateFrom.Location, NavigateFrom.Guide {
    private ActivityMainBinding binding;
    public static Egypt mainLocation;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        fragmentManager = getSupportFragmentManager();
        try {
            mainLocation = Egypt.init(getResources());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        if (savedInstanceState!=null){
            Fragment detailsFragment = fragmentManager.getFragment(savedInstanceState,"details_fragment");
            Fragment guideFragment = fragmentManager.getFragment(savedInstanceState,"guide_fragment");
            if (detailsFragment !=null){
                fragmentManager.beginTransaction()
                        .add(R.id.fragment_container,detailsFragment);
            }else{
                addGuideFragment(guideFragment);
            }
        }else{
            Fragment guideFragment = new GuideFragment();
            addGuideFragment(guideFragment);
        }

    }

    private void addGuideFragment(Fragment guideFragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, guideFragment, "guide_fragment")
                .commit();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Fragment detailsFragment = fragmentManager.findFragmentByTag("details_fragment");
        Fragment guideFragment = fragmentManager.findFragmentByTag("guide_fragment");
        if (detailsFragment!=null){
            fragmentManager.putFragment(outState,"details_fragment",detailsFragment);
            fragmentManager.putFragment(outState,"guide_fragment",guideFragment);
        }else{
            fragmentManager.putFragment(outState,"guide_fragment",guideFragment);
        }
    }

    @Override
    public void toGuide() {
        Fragment guideFragment = new GuideFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container,guideFragment);
        fragmentManager.popBackStack("location_details",FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public void toLocation(GuideLocation location) {
        Fragment locationDetailsFragment = LocationDetailsFragment.newInstance(location);
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container,locationDetailsFragment,"details_fragment")
                .addToBackStack("location_details")
                .commit();
    }
}
