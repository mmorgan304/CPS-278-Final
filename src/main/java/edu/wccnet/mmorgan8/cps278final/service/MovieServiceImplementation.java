package edu.wccnet.mmorgan8.cps278final.service;

import edu.wccnet.mmorgan8.cps278final.components.Search;
import edu.wccnet.mmorgan8.cps278final.dao.MovieDAO;
import edu.wccnet.mmorgan8.cps278final.entities.Checkout;
import edu.wccnet.mmorgan8.cps278final.entities.Genre;
import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;
import edu.wccnet.mmorgan8.cps278final.exceptions.MovieNotFoundException;
import edu.wccnet.mmorgan8.cps278final.exceptions.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImplementation implements MovieService {
    @Autowired
    MovieDAO movieDAO;

    // Model population methods
    @Override
    public Map<String, String> populateRatings() {
        Map<String, String> ratings = new LinkedHashMap<>();
        ratings.put("NR", "NR");
        ratings.put("G", "G");
        ratings.put("PG", "PG");
        ratings.put("PG-13", "PG-13");
        ratings.put("R", "R");
        ratings.put("NC-17", "NC-17");
        return ratings;
    }

    @Override
    @Transactional
    public List<Genre> populateGenres() {
        return movieDAO.getGenres();
    }

    // User methods
    @Override
    @Transactional
    public List<User> populateUsers() {
        return movieDAO.getAllUsers();
    }

    // Save methods
    @Override
    @Transactional
    public void saveMovie(Movie movie) {
        movieDAO.saveMovie(movie);
    }

    @Override
    @Transactional
    public void saveCheckout(Checkout checkout) {
        movieDAO.saveCheckout(checkout);
    }

    // Search methods
    @Override
    @Transactional
    public List<Movie> getSearchResults(Search searchTerms) {
        return movieDAO.getSearchResults(searchTerms);
    }

    @Override
    @Transactional
    public Movie getMovieByTitle(String movieTitle) {
        Movie theMovie = movieDAO.getMoveByTitle(movieTitle);
        if (theMovie == null) {
            throw new MovieNotFoundException("Movie not found: " + movieTitle);
        }
        return movieDAO.getMoveByTitle(movieTitle);
    }

    @Override
    @Transactional
    public Movie getMovieById(int movieId) {
        return movieDAO.getMovieById(movieId);
    }

    @Override
    @Transactional
    public Checkout getCheckoutById(int checkoutId) {
        return movieDAO.getCheckoutById(checkoutId);
    }

    @Override
    @Transactional
    public void changeInventory(Movie movie, int change) {
        movieDAO.changeInventory(movie, change);
    }

    // Search methods
    @Override
    @Transactional
    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        User theUser = movieDAO.getUserById(id);
        if (theUser == null) {
            throw new UserNotFoundException("User not found: " + id);
        }
        return movieDAO.getUserById(id);
    }
}
