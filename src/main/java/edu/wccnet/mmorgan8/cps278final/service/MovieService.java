package edu.wccnet.mmorgan8.cps278final.service;

import edu.wccnet.mmorgan8.cps278final.components.Search;
import edu.wccnet.mmorgan8.cps278final.entities.Checkout;
import edu.wccnet.mmorgan8.cps278final.entities.Genre;
import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;

import java.util.List;
import java.util.Map;

public interface MovieService {
    // Model population methods
    public Map<String, String> populateRatings();
    public List<Genre> populateGenres();
    public List<User> populateUsers();

    // Movie methods
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    void saveCheckout(Checkout checkout);

    // Search methods
    User getUserById(int id);
    List<Movie> getSearchResults(Search searchTerms);
    Movie getMovieByTitle(String movieTitle);
    Movie getMovieById(int movieId);
    Checkout getCheckoutById(int checkoutId);

    void changeInventory(Movie movie, int change);
}
