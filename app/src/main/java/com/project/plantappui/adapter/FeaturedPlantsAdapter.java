package com.project.plantappui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.plantappui.R;
import com.project.plantappui.menu.home.HomeDetailActivity;
import com.project.plantappui.model.Plant;
import com.project.plantappui.viewholder.FeaturedPlantsViewHolder;

import java.util.ArrayList;

public class FeaturedPlantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final ArrayList<Plant> plants;

    public FeaturedPlantsAdapter(Context context, ArrayList<Plant> plants) {
        this.context = context;
        this.plants = plants;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_plants_item, parent, false);
        return new FeaturedPlantsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setImage(((FeaturedPlantsViewHolder) holder).featured_plants_picture, plants.get(position).getPlantPicture());
        setOnClick(((FeaturedPlantsViewHolder) holder).featured_plants_parent);
        setTitle(((FeaturedPlantsViewHolder) holder).featured_plants_title, plants.get(position).getPlantTitle());
        setCountry(((FeaturedPlantsViewHolder) holder).featured_plants_country, plants.get(position).getPlantCountry());
        setPrice(((FeaturedPlantsViewHolder) holder).featured_plants_price, plants.get(position).getPlantPrice());
    }

    private void setImage(final ImageView imageView, int image) {
        imageView.setBackgroundResource(image);
//        Picasso.get().load(imageURL).fit().centerCrop().into(imageView, new Callback() {
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//                imageView.setBackgroundResource(R.drawable.ic_launcher_background);
//            }
//        });
    }

    private void setOnClick(RelativeLayout button) {
        button.setOnClickListener(view -> context.startActivity(new Intent(context, HomeDetailActivity.class)));
    }

    private void setTitle(TextView textView, String plantTitle) {
        textView.setText(plantTitle);
    }

    private void setCountry(TextView textView, String plantCountry) {
        textView.setText(plantCountry);
    }

    private void setPrice(TextView textView, String plantPrice) {
        textView.setText(plantPrice);
    }

    @Override
    public int getItemCount() {
        return plants.size();
    }
}
