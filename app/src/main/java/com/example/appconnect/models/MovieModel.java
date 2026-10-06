package com.example.appconnect.models;

import com.example.appconnect.R;

import java.util.List;

public class MovieModel {
    private String title;
    private String year;
    private String duration;
    private String ageRating;
    private String genreCategory;
    private String badge;
    private String rating;
    private int posterResId;

    public MovieModel(double rating, String badge, String title, int year, int duration, String ageRating, String genreCategory, int posterResId) {
        this.rating = String.valueOf(rating);
        this.badge = badge;
        this.title = title;
        this.year = String.valueOf(year);
        this.duration = duration + " Minutes";
        this.ageRating = ageRating;
        this.genreCategory = genreCategory;
        this.posterResId = posterResId;
    }

    public MovieModel(String title, String year, String duration, String ageRating, String genreCategory, String badge, String rating, int posterResId) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genreCategory = genreCategory;
        this.badge = badge;
        this.rating = rating;
        this.posterResId = posterResId;
    }

    public MovieModel(String title, String year, String duration, String ageRating, String genreCategory, String badge, String rating, String posterUrl) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genreCategory = genreCategory;
        this.badge = badge;
        this.rating = rating;
        try {
            this.posterResId = Integer.parseInt(posterUrl);
        } catch (NumberFormatException e) {
            this.posterResId = 0;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(String ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenreCategory() {
        return genreCategory;
    }

    public void setGenreCategory(String genreCategory) {
        this.genreCategory = genreCategory;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPosterResId() {
        return posterResId;
    }

    public void setPosterResId(int posterResId) {
        this.posterResId = posterResId;
    }

    public int getPosterUrl() {
        return posterResId;
    }

    public void setPosterUrl(String posterUrl) {
        try {
            this.posterResId = Integer.parseInt(posterUrl);
        } catch (NumberFormatException e) {
            this.posterResId = 0;
        }
    }

    public static List<MovieModel> generateData() {
        return List.of(
                new MovieModel(4.8, "Premium", "Inception", 2010, 148, "NC-15", "Sci-Fi | Movie", R.drawable.movie_1),
                new MovieModel(0, "Free", "The Dark Knight", 2008, 152, "NC-15", "Action | Movie", R.drawable.movie_2),
                new MovieModel(1.5, "Premium", "Pulp Fiction", 1994, 154, "R-18", "Crime | Movie", R.drawable.movie_1),
                new MovieModel(4.1, "Free", "Interstellar", 2014, 169, "NC-15", "Sci-Fi | Movie", R.drawable.movie_2),
                new MovieModel(0, "Premium", "Spider-Man: Into the Spider-Verse", 2018, 117, "G", "Animation | Movie", R.drawable.movie_1),
                new MovieModel(0.8, "Free", "Parasite", 2019, 132, "R-18", "Thriller | Movie", R.drawable.movie_2),
                new MovieModel(5.0, "Premium", "The Lord of the Rings: The Fellowship of the Ring", 2001, 178, "NC-15", "Fantasy | Movie", R.drawable.movie_1),
                new MovieModel(3.7, "Free", "Spirited Away", 2001, 125, "G", "Animation | Movie", R.drawable.movie_2),
                new MovieModel(4.3, "Premium", "The Matrix", 1999, 136, "NC-15", "Sci-Fi | Movie", R.drawable.movie_1),
                new MovieModel(2.1, "Free", "Whiplash", 2014, 106, "NC-15", "Drama | Drama", R.drawable.movie_2),
                new MovieModel(3.9, "Premium", "Iron Man", 2008, 126, "NC-15", "Action | Movie", R.drawable.movie_1),
                new MovieModel(4.6, "Free", "Coco", 2017, 105, "G", "Animation", R.drawable.movie_2),
                new MovieModel(1.2, "Premium", "Blade Runner 2049", 2017, 164, "R-18", "Sci-Fi | Movie", R.drawable.movie_1),
                new MovieModel(3.4, "Free", "Grand Budapest Hotel", 2014, 99, "NC-15", "Comedy | Movie", R.drawable.movie_2),
                new MovieModel(4.9, "Premium", "The Silence of the Lambs", 1991, 118, "R-18", "Horror | Movie", R.drawable.movie_1),
                new MovieModel(2.5, "Free", "Get Out", 2017, 104, "R-18", "Horror | Movie", R.drawable.movie_2),
                new MovieModel(3.8, "Premium", "Knives Out", 2019, 130, "NC-15", "Mystery | Movie", R.drawable.movie_1),
                new MovieModel(4.4, "Free", "Toy Story", 1995, 81, "G", "Animation", R.drawable.movie_2),
                new MovieModel(1.9, "Premium", "Alien", 1979, 117, "R-18", "Sci-Fi | Movie", R.drawable.movie_1),
                new MovieModel(3.0, "Free", "Avatar", 2009, 162, "NC-15", "Action | Movie", R.drawable.movie_2)
        );
    }
}
