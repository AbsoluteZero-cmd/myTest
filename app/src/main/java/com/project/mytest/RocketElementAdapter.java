package com.project.mytest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.islamkhsh.CardSliderAdapter;

import java.util.ArrayList;

public class RocketElementAdapter extends CardSliderAdapter<RocketElementAdapter.RocketElementViewHolder> {
    private ArrayList<RocketElement> elements;

    public RocketElementAdapter(ArrayList<RocketElement> elements){
        this.elements = elements;
    }

    @Override
    public void bindVH(@NonNull RocketElementAdapter.RocketElementViewHolder rocketElementViewHolder, int i) {
        // TODO bind item object with item layout view
        rocketElementViewHolder.bind(elements.get(i));
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

        public RocketElementViewHolder(@NonNull View itemView) {
            super(itemView);
            elementName = itemView.findViewById(R.id.element_item_name);

        }

        public void bind(RocketElement rocketElement) {
            elementName.setText(rocketElement.name);
        }
    }
}
