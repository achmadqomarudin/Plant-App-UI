package com.project.plantappui.menu.home;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.plantappui.R;
import com.project.plantappui.adapter.HomeDetailAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class HomeDetailActivity extends AppCompatActivity {
    private ImageButton buttonBack;
    private final List<Integer> imagesList = new ArrayList<>();
    private ViewPager viewPager;
    private HomeDetailAdapter adapter;
    private WormDotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_home_detail);

        setViews();
        initViews();
        initData();
    }

    @SuppressLint("ObsoleteSdkInt")
    private void hideStatusBar() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().getDecorView().setSystemUiVisibility(3328);
            } else {
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setViews() {
        buttonBack  = findViewById(R.id.button_back);
        viewPager   = findViewById(R.id.view_pager);
    }

    private void initViews() {
        buttonBack.setOnClickListener(view -> onBackPressed());
    }

    private void initData() {
        /**Add Images List**/
        imagesList.add(R.drawable.detail_home_picture);
        imagesList.add(R.drawable.detail_home_picture);
        imagesList.add(R.drawable.detail_home_picture);
        imagesList.add(R.drawable.detail_home_picture);
        imagesList.add(R.drawable.detail_home_picture);

        adapter = new HomeDetailAdapter(getApplicationContext(), getLayoutInflater(), imagesList);
        viewPager.setAdapter(adapter);

        dotsIndicator = findViewById(R.id.layout_dot);
        dotsIndicator.setViewPager(viewPager);

        adapter.notifyDataSetChanged();
    }
}