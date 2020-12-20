package com.project.plantappui.menu.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.plantappui.R;
import com.project.plantappui.adapter.GroupAdapter;
import com.project.plantappui.model.Group;
import com.project.plantappui.model.Plant;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private Context mContext;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GroupAdapter groupAdapter;
    private ArrayList<Group> groups;
    private ArrayList<Plant> featured_plants;
    private ArrayList<Plant> recommended;
    //todo 0. If you want to add more types of objects, you can easily do so. Check "todo list" (I added it step by step)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAdapterType(view);
        setAdapter();
    }

    private void initGroupData() {
        groups = new ArrayList<>();
        groups.add(new Group("Recommended", "More"));
        groups.add(new Group("Featured Plants", "More"));
    }

    private void initPlantData() {
        featured_plants = new ArrayList<>();
        recommended     = new ArrayList<>();

        featured_plants.add(new Plant("Colorado Columbines", "Indonesia", "$300", R.drawable.bottom_img_1));
        featured_plants.add(new Plant("Common Mallows", "Russia", "$200", R.drawable.bottom_img_1));
        featured_plants.add(new Plant("Cherry Blossom", "Italy", "$100", R.drawable.bottom_img_1));

        recommended.add(new Plant("Aquilegia", "Indonesia", "$600", R.drawable.image_1));
        recommended.add(new Plant("Angelica", "Russia", "$500", R.drawable.image_2));
        recommended.add(new Plant("Camellia", "Italy", "$400", R.drawable.image_3));
        recommended.add(new Plant("Narcissa", "France", "$300", R.drawable.image_1));
        recommended.add(new Plant("Orchid", "China", "$200", R.drawable.image_2));
        recommended.add(new Plant("Lily", "America", "$100", R.drawable.image_3));
    }

    private void setAdapterType(View view) {
        recyclerView    = view.findViewById(R.id.recyclerView);
        layoutManager   = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        initGroupData();
        initPlantData();
        //todo 1. Add the new object to the parameter list.
        groupAdapter = new GroupAdapter(mContext, groups, featured_plants, recommended);
        recyclerView.setAdapter(groupAdapter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}