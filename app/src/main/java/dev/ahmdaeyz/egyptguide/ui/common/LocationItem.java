package dev.ahmdaeyz.egyptguide.ui.common;

import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.xwray.groupie.viewbinding.BindableItem;

import java.util.Optional;

import dev.ahmdaeyz.egyptguide.R;
import dev.ahmdaeyz.egyptguide.data.entities.Egypt;
import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;
import dev.ahmdaeyz.egyptguide.databinding.LocationItemBinding;
import dev.ahmdaeyz.egyptguide.ui.utils.Binding;

public class LocationItem extends BindableItem<LocationItemBinding> {

    private final GuideLocation location;
    public LocationItem(GuideLocation location){
        this.location = location;
    }

    @NonNull
    @Override
    protected LocationItemBinding initializeViewBinding(@NonNull View view) {
        return LocationItemBinding.bind(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void bind(@NonNull LocationItemBinding viewBinding, int position) {
        viewBinding.locationName.setText(location.getName());
        viewBinding.locationExact.setText(location.getExactLocation());
        Binding.bindImageViewWithRoundedCorners(
                viewBinding.locationImage,
                Egypt.getDrawables().get(location.getName()),
                Optional.empty()
        );
    }

    @Override
    public int getLayout() {
        return R.layout.location_item;
    }

    public GuideLocation getLocation() {
        return location;
    }
}
