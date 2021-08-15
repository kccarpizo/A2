
package com.example.restapiassign2.controller;

import com.example.restapiassign2.CustomResponse;
import com.example.restapiassign2.models.TV;
import com.example.restapiassign2.services.TvService;
import java.util.Collections;
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
public class TvController {
    @Autowired
    private TvService tService;
    
    @GetMapping("/tvs")
    public ResponseEntity getMovies(){
        //return mService.getMovies();
        var customResponse = new CustomResponse(" All tv shows" , tService.getTVs());
        return new ResponseEntity(customResponse, HttpStatus.OK);
    }
    
    @GetMapping("/tvs/{id}")
    public ResponseEntity getTv(@PathVariable("id") String id){
        
        CustomResponse customResponse = null;
        try {
            customResponse = new CustomResponse("The TV show " + id , Collections.singletonList(tService.getTv(id)));
        } catch (Exception e) {

            customResponse = new CustomResponse(e.getMessage(), null);

            return new ResponseEntity(customResponse, HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity(customResponse, HttpStatus.OK);
    }
    
    @GetMapping("/tvs/featured")
    public ResponseEntity getFeaturedMovies(@RequestParam(value = "featured") String f)
    {

        var customizedResponse = new CustomResponse(" Featured TV shows : " , tService.getFeatured(f));

        return new ResponseEntity(customizedResponse, HttpStatus.OK);
    }
    
    @DeleteMapping("/tvs/{id}")
    public ResponseEntity deleteTv(@PathVariable("id") String id){
        tService.deleteTv(id);
        var customResponse = new CustomResponse(" Tv Show deleted");
        return new ResponseEntity(customResponse, HttpStatus.OK);
    }
    
    @PostMapping(value = "/tvs", consumes = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addTv(@RequestBody TV tv){
        tService.insertIntoTvs(tv);
        
        return new ResponseEntity(tv, HttpStatus.OK);
    }
    
    @PutMapping(value = "/tvs/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity editTv(@PathVariable("id") String id, @RequestBody TV newTv )

    {


        var customResponse = new CustomResponse(" TV show that has ID:  " + id + "was  successfully updated " , Collections.singletonList(tService.editTv(id, newTv)));

        return new ResponseEntity( customResponse, HttpStatus.OK);




    }
}
