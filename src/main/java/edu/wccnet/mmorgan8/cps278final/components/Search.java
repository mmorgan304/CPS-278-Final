package edu.wccnet.mmorgan8.cps278final.components;

import edu.wccnet.mmorgan8.cps278final.entities.Genre;

public class Search {
    private String title;
    private String description;
    private Genre genre;

    public Search() {}

    public Search(String title, String description, Genre genre) {
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Search{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                '}';
    }
}

