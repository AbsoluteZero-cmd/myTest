package com.project.mytest;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.jama.carouselview.CarouselView;

import java.util.ArrayList;

public class SettingsFragment extends Fragment {
    AppCompatButton sizeButton, colorButton;

    ArrayList<RocketElement> itemsArrayList = new ArrayList<>();

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

//        CarouselView carouselView = view.findViewById(R.id.elements_carousel);

        sizeButton = view.findViewById(R.id.button_1);
        colorButton = view.findViewById(R.id.button_2);

        return view;
    }
}