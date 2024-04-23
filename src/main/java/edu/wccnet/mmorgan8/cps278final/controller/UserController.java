package edu.wccnet.mmorgan8.cps278final.controller;

import edu.wccnet.mmorgan8.cps278final.components.Search;
import edu.wccnet.mmorgan8.cps278final.entities.Checkout;
import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;
import edu.wccnet.mmorgan8.cps278final.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MovieService movieService;

    @ModelAttribute("user")
    public User getUser(@RequestParam("userId") int id) {
        return movieService.getUserById(id);
    }

    @ModelAttribute
    public void addMovieAttributes(Model model) {
        model.addAttribute("ratingsList", movieService.populateRatings());
        model.addAttribute("genreList", movieService.populateGenres());
    }

    @RequestMapping("/main")
    public String userMain() {
        return "userPages/userMain";
    }

    @RequestMapping("/movieLibrary")
    public String movieLibrary(Model model) {
        model.addAttribute("movieList", movieService.getAllMovies());
        return "userPages/movieLibrary";
    }

    @RequestMapping("/searchMovie")
    public String searchMovie(Model model) {
        Search newSearch = new Search();
        model.addAttribute("searchTerms", newSearch);
        return "userPages/searchMovie";
    }

    @PostMapping("/processSearchRequest")
    public String processSearchRequest(Model model,
                                       @ModelAttribute("searchTerms") Search searchTerms) {
        List<Movie> searchResults = movieService.getSearchResults(searchTerms);
        model.addAttribute("movieList", searchResults);
        return "userPages/movieLibrary";
    }

    @PostMapping("/checkMovieOut")
    public String checkMovieOut(Model model,
                                @RequestParam int movieId,
                                @RequestParam int userId) {
        Movie movie = movieService.getMovieById(movieId);
        movieService.changeInventory(movie, -1);
        User user = (User) model.getAttribute("user");
        Checkout checkout = new Checkout(user, movie);
        checkout.setCheckoutDate(Instant.now());
        movieService.saveCheckout(checkout);
        return "redirect:/user/main?userId=" + userId;
    }

    @PostMapping("/returnMovie")
    public String returnMovie(Model model,
                              @RequestParam("checkoutId") int checkoutId,
                              @RequestParam("userId") int userId) {
        Checkout checkout = movieService.getCheckoutById(checkoutId);
        Movie movie = movieService.getMovieById(checkout.getMovie().getId());
        movieService.changeInventory(movie, 1);
        checkout.setReturnDate(Instant.now());
        movieService.saveCheckout(checkout);
        return "redirect:/user/main?userId=" + userId;
    }
}
