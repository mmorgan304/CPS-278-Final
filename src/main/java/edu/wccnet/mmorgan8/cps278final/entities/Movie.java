package edu.wccnet.mmorgan8.cps278final.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 100)
    @Size(max = 100, message = "Must be less than 100 characters")
    private String title;

    @Column(name = "synopsis", length = 1000)
    @Size(max = 1000, message = "Must be less than 1000 characters")
    private String synopsis;

    @Column(name = "length", length = 4)
    @Size(max = 4)
    @Pattern(regexp = "^(?:1000|[1-9]\\d{0,2})$", message = "Length must be between 0 and 1000")
    private String length;

    @Column(name = "year", length = 4)
    @Pattern(regexp = "^(19[0-9]{2}|20[0-1][0-9]|202[0-4])$", message = "Invalid Year")
    private String year;

    @Column(name = "rating", length = 45)
    private String rating;

    @Column(name = "total_copies", nullable = false)
    @NotNull(message = "Total copies must not be null")
    @Min(value = 0, message = "Total copies must be a positive whole number")
    private Integer totalCopies;

    @Column(name = "available_copies", nullable = false)
    @Min(value = 0, message = "Available copies must be a whole number")
    private Integer availableCopies;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genreList;

    public Movie() {
    }

    public Movie(String title, String synopsis, String length, String year, String rating) {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Integer getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(Integer totalCopies) {
        this.totalCopies = totalCopies;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }
}