package com.example.tp_star.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tp_star.R;
import com.example.tp_star.beans.Star;

import java.util.ArrayList;
import java.util.List;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> {
    private List<Star> stars;
    private List<Star> originalStars; // Liste originale pour le filtrage
    private Context context;

    public StarAdapter(Context context, List<Star> stars) {
        this.context = context;
        this.stars = stars;
        this.originalStars = new ArrayList<>(stars); // Initialiser la liste originale
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.star_item, viewGroup, false);
        return new StarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = stars.get(position);
        holder.name.setText(star.getName());
        holder.stars.setRating(star.getStarRating());

        holder.img.setImageResource(star.getImageResource()); // Utilisation de l'image locale
    }

    @Override
    public int getItemCount() {
        return stars.size();
    }

    public void filter(String text) {
        List<Star> filteredStars = new ArrayList<>();
        if (text.isEmpty()) {
            filteredStars.addAll(originalStars);
        } else {
            text = text.toLowerCase();
            for (Star star : originalStars) {
                if (star.getName().toLowerCase().contains(text)) {
                    filteredStars.add(star);
                }
            }
        }
        stars.clear();
        stars.addAll(filteredStars);
        notifyDataSetChanged();
    }

    public static class StarViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        RatingBar stars;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            stars = itemView.findViewById(R.id.stars);
        }
    }
}
