package com.example.mohamedhassan.traininghub.RoomDetails;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mohamedhassan.traininghub.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private Integer [] images = {R.drawable.training_courses,R.drawable.avatar,R.drawable.home};


    public ViewPagerAdapter(Context context) {
        this.context = context;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {


        LayoutInflater  layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewItem = layoutInflater.inflate(R.layout.image_viewpager_room_detials, null);
        ImageView itemImage= viewItem.findViewById(R.id.imageView);
        itemImage.setImageResource(images[position]);
        ((ViewPager) container).addView(viewItem, 0);

        return viewItem;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);



    }
}
