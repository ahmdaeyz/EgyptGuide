package dev.ahmdaeyz.egyptguide.ui.utils;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Optional;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

public class Binding {

    public static void bindImageViewWithRoundedCorners(@NonNull ImageView imageView, @NonNull Integer resId, Optional<Integer> radius) {
        Glide.with(imageView)
                .load(resId)
                .apply(RequestOptions.bitmapTransform(new RoundedCornersTransformation(radius.orElse(20),0, RoundedCornersTransformation.CornerType.ALL)))
                .into(imageView);
    }
}
