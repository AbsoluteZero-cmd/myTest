package com.project.mytest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.github.islamkhsh.CardSliderAdapter;

import java.io.File;
import java.util.ArrayList;

public class RocketElementAdapter extends CardSliderAdapter<RocketElementAdapter.RocketElementViewHolder> {
    private ArrayList<RocketElement> elements;
    private Context context;

    public RocketElementAdapter(ArrayList<RocketElement> elements, Context context){
        this.elements = elements;
        this.context = context;
    }

    @Override
    public void bindVH(@NonNull RocketElementAdapter.RocketElementViewHolder rocketElementViewHolder, int i) {
        // TODO bind item object with item layout view
        rocketElementViewHolder.bind(elements.get(i), context);
    }

    @NonNull
    @Override
    public RocketElementAdapter.RocketElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_layout, parent, false);
        return new RocketElementViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public class RocketElementViewHolder extends RecyclerView.ViewHolder {
        private TextView elementName;
        private ImageView elementImage;

        public RocketElementViewHolder(@NonNull View itemView) {
            super(itemView);
            elementName = itemView.findViewById(R.id.element_item_name);
            elementImage = itemView.findViewById(R.id.element_item_image);
        }

        public void bind(RocketElement rocketElement, Context context) {
            elementName.setText(rocketElement.getName());

            if(rocketElement.getId() != 0){
                elementImage.setImageResource(rocketElement.getId());
            }
        }
    }
}
