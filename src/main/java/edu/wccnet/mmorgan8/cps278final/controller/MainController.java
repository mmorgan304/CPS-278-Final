package edu.wccnet.mmorgan8.cps278final.controller;

import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;
import edu.wccnet.mmorgan8.cps278final.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private MovieService movieService;

    @ModelAttribute
    public void addUserAttributes(Model model) {
        model.addAttribute("userList", movieService.populateUsers());
    }

    @GetMapping("/landingPage")
    public String landing(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "landingPage";
    }

    @GetMapping("/movieDetailsPage")
    public String movieDetailsPage(Model model,
                                   @RequestParam int movieId) {
        Movie movie = movieService.getMovieById(movieId);
        model.addAttribute(movie);
        return "movieDetailsPage";
    }
}
