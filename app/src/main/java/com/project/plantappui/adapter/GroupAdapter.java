package com.project.plantappui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.plantappui.R;
import com.project.plantappui.model.Group;
import com.project.plantappui.model.Plant;
import com.project.plantappui.viewholder.GroupViewHolder;

import java.util.ArrayList;

public class GroupAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<Group> groups;
    private ArrayList<Plant> featured_plants;
    private ArrayList<Plant> recommended;
    //todo 2. Create a new list with the new object

    public GroupAdapter(Context context, ArrayList<Group> groups, ArrayList<Plant> featured_plants, ArrayList<Plant> recommended) {
        //todo 3. Add it to the constructor
        this.context = context;
        this.groups = groups;
        this.featured_plants = featured_plants;
        this.recommended = recommended;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item, parent, false);
        return new GroupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        setGroupTitle(((GroupViewHolder) holder).group_title, groups.get(position).getGroupTitle());
        setGroupButtonTitle(((GroupViewHolder) holder).view_all, groups.get(position).getGroupButtonTitle());
        setOnClickViewAll(((GroupViewHolder) holder).head_parent, groups.get(position).getGroupTitle());
        setLists(((GroupViewHolder) holder).group_recycler_view, position);
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    private void setGroupTitle(TextView textView, String text) {
        textView.setText(text);
    }

    private void setGroupButtonTitle(Button button, String text) {
        button.setText(text);
    }

    private void setOnClickViewAll(RelativeLayout button, final String groupTitle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "View all " + groupTitle, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setLists(RecyclerView recyclerView, int position) {
        //todo 4. Create a new adapter for it and display it in the list
        switch (position) {
            case 0:
                setRecommendedList(recyclerView);
                break;
            case 1:
                setFeaturedPlantsList(recyclerView);
                break;
        }
    }

    private void setFeaturedPlantsList(RecyclerView recyclerView) {
        FeaturedPlantsAdapter featuredPlantsAdapter = new FeaturedPlantsAdapter(context, featured_plants);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(featuredPlantsAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }

    private void setRecommendedList(RecyclerView recyclerView) {
        RecommendedAdapter simpleAdapter = new RecommendedAdapter(context, recommended);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(simpleAdapter);
        recyclerView.setNestedScrollingEnabled(true);
    }
}

