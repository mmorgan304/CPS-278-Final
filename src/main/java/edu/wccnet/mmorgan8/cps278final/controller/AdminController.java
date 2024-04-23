package edu.wccnet.mmorgan8.cps278final.controller;

import edu.wccnet.mmorgan8.cps278final.components.Search;
import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MovieService movieService;

    @ModelAttribute
    public void addMovieAttributes(Model model) {
        model.addAttribute("ratingsList", movieService.populateRatings());
        model.addAttribute("genreList", movieService.populateGenres());
    }

    @RequestMapping("/main")
    public String adminMain() {
        return "adminPages/adminMain";
    }

    @GetMapping("/addMovie")
    public String addMovie(Model model) {
        Movie movie = new Movie();
        model.addAttribute("newMovie", movie);
        return "adminPages/addMovie";
    }

    @PostMapping("/processMovie")
    public String processMovie(
            @Valid
            @ModelAttribute("newMovie") Movie newMovie,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "adminPages/addMovie";
        } else {
            newMovie.setAvailableCopies(newMovie.getTotalCopies());
            movieService.saveMovie(newMovie);
            return "redirect:/admin/movieLibrary";
        }
    }

    @RequestMapping("/movieLibrary")
    public String movieLibrary(Model model) {
        model.addAttribute("movieList", movieService.getAllMovies());
        return "adminPages/movieLibrary";
    }

    @RequestMapping("/searchMovie")
    public String searchMovie(Model model) {
        Search newSearch = new Search();
        model.addAttribute("searchTerms", newSearch);
        return "adminPages/searchMovie";
    }

    @GetMapping("/processSearchRequest")
    public String processSearchRequest(Model model,
                                       @ModelAttribute("searchTerms") Search searchTerms) {
        List<Movie> searchResults = movieService.getSearchResults(searchTerms);
        System.out.println(searchResults);
        model.addAttribute("movieList", searchResults);
        return "adminPages/movieLibrary";
    }

}
