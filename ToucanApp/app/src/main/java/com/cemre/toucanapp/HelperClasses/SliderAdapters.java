package com.cemre.toucanapp.HelperClasses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cemre.toucanapp.R;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.*;


public class SliderAdapters extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;



    public SliderAdapters(Context context) {
        this.context = context;
    }

    int images[] = {
            R.drawable.splashscreen,
            R.drawable.onboaring2,

    };

    int headings[] = {
            R.string.slogan1,
            R.string.slogan3,

    };

    int descriptions[] = {
            R.string.slogan2,
            R.string.slogan4,

    };

    @Override
    public int getCount() {
        return headings.length ;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout, container,false);

        //HOOKS
        ImageView imageView = view.findViewById(R.id.sliderImage);
        TextView heading = view.findViewById(R.id.sliderHeading);
        TextView desc = view.findViewById(R.id.sliderDesc);

        imageView.setImageResource(images[position]);
        heading.setText(headings[position]);
        desc.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}