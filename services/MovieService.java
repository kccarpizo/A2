
package com.example.restapiassign2.services;

import com.example.restapiassign2.models.MovieRepository;
import com.example.restapiassign2.models.Movies;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author kimberlycarpizo
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRep;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Movies> getMovies(){
        return movieRep.findAll();
    }
  
    public void insertIntoMovies(Movies movie){
        movieRep.insert(movie);
    }
    
    public List<Movies> getFeatured(String f)

    {

        
        Query query = new Query();
        query.addCriteria(Criteria.where("featured" ).is(f));
        List<Movies> movies = mongoTemplate.find(query, Movies.class);
        return movies;

    }

    
    public Optional<Movies> getMovie(String id){
        return movieRep.findById(id);
    }
    
    
    public void deleteMovie(String id){
        movieRep.deleteById(id);
    }
    
    public Movies editMovie(String id, Movies newMovie)
    {
        

       Optional<Movies> movie = movieRep.findById(id);

       
       movie.get().setTitle(newMovie.getTitle());
       movie.get().setDescription(newMovie.getDescription());
       movie.get().setLm(newMovie.getLm());
       movie.get().setVal(newMovie.getVal());
       movie.get().setSm(newMovie.getSm());
       movie.get().setPrice(newMovie.getPrice());
       movie.get().setPriceOut(newMovie.getPriceOut());
       movie.get().setFeatured(newMovie.getFeatured());
       

       Movies updateMovie = movieRep.save(movie.get());

       return updateMovie;



    }
}
