package dev.ahmdaeyz.egyptguide.ui.common;

import android.view.View;

import androidx.annotation.NonNull;

import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;

public interface OnItemClickListener {
    void onItemClick(@NonNull GuideLocation location, @NonNull View view);
}
