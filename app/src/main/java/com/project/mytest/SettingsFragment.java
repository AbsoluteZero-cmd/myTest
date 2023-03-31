package com.project.mytest;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.jama.carouselview.CarouselView;

import com.madrapps.pikolo.ColorPicker;
import com.madrapps.pikolo.listeners.SimpleColorSelectionListener;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {
    AppCompatButton sizeButton, colorButton;

    ArrayList<RocketElement> itemsArrayList = new ArrayList<>();
    int kColor = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        itemsArrayList.add(new RocketElement("Nose Cone"));
        itemsArrayList.add(new RocketElement("Body Tube"));
        itemsArrayList.add(new RocketElement("Transition"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        final ColorPicker colorPicker = view.findViewById(R.id.colorPicker);
        final View elementsCarousel = view.findViewById(R.id.elements_frame);

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