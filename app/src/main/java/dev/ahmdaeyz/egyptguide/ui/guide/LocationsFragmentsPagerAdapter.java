package dev.ahmdaeyz.egyptguide.ui.guide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import dev.ahmdaeyz.egyptguide.ui.guide.churches.ChurchesFragment;
import dev.ahmdaeyz.egyptguide.ui.guide.famouscities.FamousCitiesFragment;
import dev.ahmdaeyz.egyptguide.ui.guide.mosques.MosquesFragment;
import dev.ahmdaeyz.egyptguide.ui.guide.museums.MuseumsFragment;

public class LocationsFragmentsPagerAdapter extends FragmentPagerAdapter {
    @NonNull
    private final String[] pageTitles = {"Cities","Mosques","Churches","Museums"};

    public LocationsFragmentsPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new FamousCitiesFragment();
            case 0:
                return new MosquesFragment();
            case 2:
                return new ChurchesFragment();
            case 3:
                return new MuseumsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitles[position];
    }
}
