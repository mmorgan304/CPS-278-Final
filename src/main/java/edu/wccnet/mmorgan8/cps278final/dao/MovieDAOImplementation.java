package edu.wccnet.mmorgan8.cps278final.dao;

import edu.wccnet.mmorgan8.cps278final.components.Search;
import edu.wccnet.mmorgan8.cps278final.entities.Checkout;
import edu.wccnet.mmorgan8.cps278final.entities.Genre;
import edu.wccnet.mmorgan8.cps278final.entities.Movie;
import edu.wccnet.mmorgan8.cps278final.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MovieDAOImplementation implements MovieDAO {

    @Autowired
    private SessionFactory sessionFactory;

    // Model population methods
    @Override
    public List<Genre> getGenres() {
        Query<Genre> query = sessionFactory.getCurrentSession().createQuery("from Genre", Genre.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public List<User> getAllUsers() {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return new ArrayList<>(query.getResultList());
    }

    // Save methods
    @Override
    public void saveCheckout(Checkout checkout) {
        sessionFactory.getCurrentSession().saveOrUpdate(checkout);
    }

    @Override
    public void saveMovie(Movie movie) {
        List<Genre> persistedGenres = new ArrayList<>();
        for (Genre genre : movie.getGenreList()) {
            Genre persistedGenre = findGenreByName(genre.getGenreName());
            persistedGenres.add(persistedGenre);
        }
        movie.setGenreList(persistedGenres); // Replace original genre list with persisted genres
        sessionFactory.getCurrentSession().persist(movie);
    }

    // Search methods

    @Override
    public User getUserById(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<Movie> getAllMovies() {
        Query<Movie> query = sessionFactory.getCurrentSession().createQuery("from Movie ", Movie.class);
        return new ArrayList<>(query.getResultList());
    }

    @Override
    public void changeInventory(Movie movie, int change) {
        Movie persistedMovie = sessionFactory.getCurrentSession().get(Movie.class, movie.getId());
        persistedMovie.setAvailableCopies(persistedMovie.getAvailableCopies() + change);
    }

    @Override
    public List<Movie> getSearchResults(Search search) {
        Session session = sessionFactory.getCurrentSession();
        StringBuilder queryString = new StringBuilder("FROM Movie m WHERE 1=1");
        if (!Objects.equals(search.getTitle(), "")) {
            queryString.append(" AND m.title LIKE :title");
        }
        if (!Objects.equals(search.getDescription(), "")) {
            queryString.append(" AND m.synopsis LIKE :synopsis");
        }
        if (!search.getGenre().isEmpty()) {
            queryString.append(" AND m.id IN (SELECT mg.movie FROM MovieGenre mg WHERE mg.genre = :genre)");
        }

        Query<Movie> query = session.createQuery(queryString.toString(), Movie.class);
        if (!Objects.equals(search.getTitle(), "")) {
            query.setParameter("title", "%" + search.getTitle() + "%");
        }
        if (!Objects.equals(search.getDescription(), "")) {
            query.setParameter("synopsis", "%" + search.getDescription() + "%");
        }
        if (!search.getGenre().isEmpty()) {
            query.setParameter("genre", findGenreByName(search.getGenre().getGenreName()));
        }
        return query.getResultList();
    }

    // Movie methods
    @Override
    public Movie getMoveByTitle(String movieTitle) {
        Session session = sessionFactory.getCurrentSession();
        Query<Movie> query = session.createQuery("from Movie m WHERE m.title = :title", Movie.class)
                .setParameter("title", movieTitle);
        return query.uniqueResult();
    }

    @Override
    public Movie getMovieById(int movieId) {
        return sessionFactory.getCurrentSession().get(Movie.class, movieId);
    }

    @Override
    public Checkout getCheckoutById(int checkoutId) {
        return sessionFactory.getCurrentSession().get(Checkout.class, checkoutId);
    }

    // non-service methods
    private Genre findGenreByName(String genreName) {
        Session session = sessionFactory.getCurrentSession();
        Query<Genre> query = session.createQuery("FROM Genre WHERE genreName = :genreName", Genre.class)
                .setParameter("genreName", genreName);
        return query.uniqueResult();
    }
}
