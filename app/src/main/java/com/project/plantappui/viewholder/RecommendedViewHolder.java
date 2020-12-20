package com.project.plantappui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.plantappui.R;

public class RecommendedViewHolder extends RecyclerView.ViewHolder {
    public ImageView recommended_picture;
    public RelativeLayout recommended_parent;
    public TextView recommended_title, recommended_country, recommended_price;

    public RecommendedViewHolder(@NonNull View itemView) {
        super(itemView);
        recommended_picture = itemView.findViewById(R.id.item_recommended_picture);
        recommended_parent  = itemView.findViewById(R.id.item_recommended_parent);
        recommended_title   = itemView.findViewById(R.id.item_recommended_title);
        recommended_price   = itemView.findViewById(R.id.item_recommended_price);
        recommended_country = itemView.findViewById(R.id.item_recommended_country);
    }
}
