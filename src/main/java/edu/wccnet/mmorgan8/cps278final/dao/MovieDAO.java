package edu.wccnet.mmorgan8.cps278final.dao;

import edu.wccnet.mmorgan8.cps278final.components.Search;
import edu.wccnet.mmorgan8.cps278final.entities.Checkout;
import edu.wccnet.mmorgan8.cps278final.entities.Genre;
import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;

import java.util.List;


public interface MovieDAO {
    // Model population methods
    List<Genre> getGenres();
    List<User> getAllUsers();
    User getUserById(int id);

    // Save methods
    void saveMovie(Movie movie);
    void saveCheckout(Checkout checkout);

    // Search methods
    List<Movie> getSearchResults(Search search);
    Movie getMoveByTitle(String movieTitle);
    Movie getMovieById(int movieId);
    Checkout getCheckoutById(int checkoutId);
    List<Movie> getAllMovies();

    void changeInventory(Movie movie, int change);
}
