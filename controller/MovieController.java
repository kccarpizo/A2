
package com.example.restapiassign2.controller;


import com.example.restapiassign2.CustomResponse;
import com.example.restapiassign2.models.Movies;
import com.example.restapiassign2.services.MovieService;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author kimberlycarpizo
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MovieController {
    
    @Autowired
    private MovieService mService;
    
    @GetMapping("/movies")
    public ResponseEntity getMovies(){
        //return mService.getMovies();
        var customResponse = new CustomResponse(" All movies" , mService.getMovies());
        return new ResponseEntity(customResponse, HttpStatus.OK);
    }
    
    @GetMapping("/movies/{id}")
    public ResponseEntity getMovie(@PathVariable("id") String id){
        //return mService.getMovies();
        
        CustomResponse customResponse = null;
        try {
            customResponse = new CustomResponse("The Movie " + id , Collections.singletonList(mService.getMovie(id)));
        } catch (Exception e) {

            customResponse = new CustomResponse(e.getMessage(), null);

            return new ResponseEntity(customResponse, HttpStatus.NOT_FOUND);

        }
      
        return new ResponseEntity(customResponse, HttpStatus.OK);
    }
    
  
    
    
    
    
    @GetMapping("/movies/featured")
    public ResponseEntity getFeaturedMovies(@RequestParam(value = "featured") String f)
    {

        var customizedResponse = new CustomResponse(" Featured Movies : " , mService.getFeatured(f));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/movies/{id}")
    public ResponseEntity deleteMovie(@PathVariable("id") String id){
        mService.deleteMovie(id);
        
        var customResponse = new CustomResponse(" Movie deleted");
        return new ResponseEntity(customResponse, HttpStatus.OK);
        //return new ResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping(value = "/movies", consumes = {
        MediaType.APPLICATION_JSON_VALUE
    })
    
    public ResponseEntity addMovie(@RequestBody Movies movie){
        mService.insertIntoMovies(movie);
        
        var customResponse = new CustomResponse("Movies" , Collections.singletonList(mService.getMovies()));
        
        return new ResponseEntity(customResponse, HttpStatus.OK);
    }
    
    
       
    @PutMapping(value = "/movies/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editMovie(@PathVariable("id") String id, @RequestBody Movies newMovie )

    {


        var customResponse = new CustomResponse(" Movie that has ID:  " + id + "was  successfully updated " , Collections.singletonList(mService.editMovie(id, newMovie)));

        return new ResponseEntity( customResponse, HttpStatus.OK);




    }
    
    
}
