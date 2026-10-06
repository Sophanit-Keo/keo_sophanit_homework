package com.example.appconnect.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appconnect.R;
import com.example.appconnect.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<MovieModel> movies;

    public MovieAdapter(List<MovieModel> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie_card, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.setMovie(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies != null ? movies.size() : 0;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPoster;
        private TextView tvMovieTitle;
        private TextView tvYear;
        private TextView tvDuration;
        private TextView tvAgeRating;
        private TextView tvGenreCategory;
        private TextView tvBadge;
        private TextView tvRating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvMovieTitle = itemView.findViewById(R.id.tvMovieTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvDuration = itemView.findViewById(R.id.tvDuration);
            tvAgeRating = itemView.findViewById(R.id.tvAgeRating);
            tvGenreCategory = itemView.findViewById(R.id.tvGenreCategory);
            tvBadge = itemView.findViewById(R.id.tvBadge);
            tvRating = itemView.findViewById(R.id.tvRating);
        }

        public void setMovie(MovieModel movie) {
            tvMovieTitle.setText(movie.getTitle());
            tvYear.setText(movie.getYear());
            tvDuration.setText(movie.getDuration());
            tvAgeRating.setText(movie.getAgeRating());
            tvGenreCategory.setText(movie.getGenreCategory());
            tvBadge.setText(movie.getBadge());
            tvRating.setText(movie.getRating());
            if (movie.getPosterResId() != 0) {
                ivPoster.setImageResource(movie.getPosterResId());
            }

            // Set activated state for bg_badge_plan_selector (true for Premium, false for Free)
            boolean isPremium = movie.getBadge() != null && movie.getBadge().equalsIgnoreCase("Premium");
            tvBadge.setActivated(isPremium);

            // Toggle badge between "Premium" and "Free" when clicked
            tvBadge.setOnClickListener(v -> {
                boolean newPremiumState = !tvBadge.isActivated();
                tvBadge.setActivated(newPremiumState);
                String newBadge = newPremiumState ? "Premium" : "Free";
                movie.setBadge(newBadge);
                tvBadge.setText(newBadge);
            });
        }
    }
}
