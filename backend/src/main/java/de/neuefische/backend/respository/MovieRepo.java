package de.neuefische.backend.respository;


import de.neuefische.backend.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepo  {

    private final HashMap<String, Movie> movieDB = new HashMap<>();


    public List<Movie> findAll() {
        return new ArrayList<>(movieDB.values());
    }

    public Movie save(Movie movie) {
        movieDB.put(movie.getId(), movie);
        return movie;
    }

    public Movie findById(String id) {
        return movieDB.get(id);
    }

    public Movie deleteById(String id) {
        return movieDB.remove(id);
    }
}
