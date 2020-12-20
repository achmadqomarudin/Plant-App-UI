package com.project.plantappui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.project.plantappui.R;

import java.util.List;

public class HomeDetailAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    private List<Integer> imagesList;
    private ImageView ivDetailImagesProduct;

    public HomeDetailAdapter(Context context, LayoutInflater inflater, List<Integer> imagesList) {
        this.context    = context;
        this.inflater   = inflater;
        this.imagesList = imagesList;
    }

    @Override
    public int getCount() {
        return imagesList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_images_detail_product, container, false);

        setViews(view);
        initViews(position);
        container.addView(view);

        return view;
    }

    //set view
    private void setViews(View view) {
        ivDetailImagesProduct = view.findViewById(R.id.iv_images_detail_product);
    }

    //set init
    private void initViews(int position) {
        Integer images = imagesList.get(position);

        ivDetailImagesProduct.setBackgroundResource(images);

//        Glide.with(context)
//                .load(images)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .skipMemoryCache(true)
//                .into(ivDetailImagesProduct);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }
}
