package de.neuefische.backend.service;

import de.neuefische.backend.model.Movie;
import de.neuefische.backend.respository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MovieService {

    private final MovieRepo repo;
    private final IdService idService;

    @Autowired
    public MovieService(MovieRepo repo, IdService idService) {
        this.repo = repo;
        this.idService = idService;
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public Movie addMovie(Movie movie) {
        if(movie.getTitle() == null || movie.getTitle().isEmpty()){
            throw new IllegalArgumentException("Given movie is missing mandatory title");
        }

        // Generate and set id for new movie
        movie.setId(idService.generateId());

        return repo.save(movie);
    }

    public Movie getMovie(String id) {
        return repo.findById(id);
    }

    public Movie deleteMovie(String id) {
       return repo.deleteById(id);
    }

    public Movie updateMovie(Movie movie) {
        return repo.save(movie);
    }
}
