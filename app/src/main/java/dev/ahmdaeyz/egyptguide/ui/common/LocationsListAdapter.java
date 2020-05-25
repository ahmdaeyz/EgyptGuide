package dev.ahmdaeyz.egyptguide.ui.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import dev.ahmdaeyz.egyptguide.data.entities.Egypt;
import dev.ahmdaeyz.egyptguide.data.entities.GuideLocation;
import dev.ahmdaeyz.egyptguide.databinding.LocationItemBinding;
import dev.ahmdaeyz.egyptguide.ui.utils.Binding;

public class LocationsListAdapter extends RecyclerView.Adapter<LocationsListAdapter.ViewHolder> {
    private List<GuideLocation> locationsList = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public LocationsListAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GuideLocation item = locationsList.get(position);
        holder.bind(item, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return locationsList.size();
    }

    public void addAll(Collection<GuideLocation> collection) {
        locationsList.addAll(collection);
        notifyDataSetChanged();
    }

    public void add(GuideLocation location) {
        locationsList.add(location);
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final LocationItemBinding binding;

        public ViewHolder(LocationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        static ViewHolder from(ViewGroup parent) {
            LocationItemBinding binding = LocationItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ViewHolder(binding);
        }

        void bind(GuideLocation location, OnItemClickListener onItemClickListener) {
            binding.locationName.setText(location.getName());
            binding.locationExact.setText(location.getExactLocation());
            Binding.bindImageViewWithRoundedCorners(
                    binding.locationImage,
                    Egypt.getDrawables().get(location.getName()),
                    Optional.empty()
            );
            binding.getRoot().setOnClickListener((view) -> {
                onItemClickListener.onItemClick(location, view);
            });
        }

    }

}

