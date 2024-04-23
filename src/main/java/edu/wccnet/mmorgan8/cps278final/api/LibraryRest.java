package edu.wccnet.mmorgan8.cps278final.api;

import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;
import edu.wccnet.mmorgan8.cps278final.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryRest {
    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{movieTitle}")
    public Movie getMovie(@PathVariable("movieTitle") String movieTitle) {
        return movieService.getMovieByTitle(movieTitle);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return movieService.populateUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return movieService.getUserById(userId);
    }

}
