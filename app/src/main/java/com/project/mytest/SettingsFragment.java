package com.project.mytest;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.github.islamkhsh.CardSliderViewPager;
import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {
    AppCompatButton sizeButton, colorButton;

    ArrayList<RocketElement> elementArrayList = new ArrayList<>();
    int kColor = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        elementArrayList.add(new RocketElement("Nose Cone", R.drawable.nose_cone));
        elementArrayList.add(new RocketElement("Body Tube", R.drawable.body_tube));
        elementArrayList.add(new RocketElement("Nose Cone Cap", R.drawable.nose_cone_cap));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final ColorPicker colorPicker = view.findViewById(R.id.colorPicker);
        final CardSliderViewPager elementsCarousel = (CardSliderViewPager)view.findViewById(R.id.viewPager);

        elementsCarousel.setAdapter(new RocketElementAdapter(elementArrayList, getContext()));



        colorPicker.setColorSelectionListener(new SimpleColorSelectionListener() {
            @Override
            public void onColorSelected(int color) {
                // Do whatever you want with the color
                elementsCarousel.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
                kColor = color;
                System.out.println("Current color: " + kColor);
            }
        });

//        CarouselView carouselView = view.findViewById(R.id.elements_carousel);

        return view;
    }
}