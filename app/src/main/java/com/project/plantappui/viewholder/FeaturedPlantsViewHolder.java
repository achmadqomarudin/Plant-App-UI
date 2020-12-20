package com.project.plantappui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.plantappui.R;

public class FeaturedPlantsViewHolder extends RecyclerView.ViewHolder {
    public ImageView featured_plants_picture;
    public RelativeLayout featured_plants_parent;
    public TextView featured_plants_title, featured_plants_country, featured_plants_price;

    public FeaturedPlantsViewHolder(@NonNull View itemView) {
        super(itemView);
        featured_plants_picture = itemView.findViewById(R.id.item_featured_plants_picture);
        featured_plants_parent  = itemView.findViewById(R.id.item_featured_plants_parent);
        featured_plants_title   = itemView.findViewById(R.id.item_featured_plants_title);
        featured_plants_country = itemView.findViewById(R.id.item_featured_plants_country);
        featured_plants_price   = itemView.findViewById(R.id.item_featured_plants_price);
    }
}
