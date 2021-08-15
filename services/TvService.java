
package com.example.restapiassign2.services;

import com.example.restapiassign2.models.MovieRepository;
import com.example.restapiassign2.models.TV;
import com.example.restapiassign2.models.TvRepository;
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
public class TvService {
    @Autowired
    private TvRepository tRep;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<TV> getTVs(){
        return tRep.findAll();
    }
  
    public void insertIntoTvs(TV movie){
        tRep.insert(movie);
    }
    
    public Optional<TV> getTv(String id){
        return tRep.findById(id);
    }
    
    public void deleteTv(String id){
        tRep.deleteById(id);
    }
    
    public List<TV> getFeatured(String f)

    {

        
        Query query = new Query();
        query.addCriteria(Criteria.where("featured" ).is(f));
        List<TV> tv = mongoTemplate.find(query, TV.class);
        return tv;

    }
    
    public TV editTv(String id, TV newMovie)
    {
        

       Optional<TV> movie = tRep.findById(id);

       
       movie.get().setTitle(newMovie.getTitle());
       movie.get().setDescription(newMovie.getDescription());
       movie.get().setLm(newMovie.getLm());
       movie.get().setVal(newMovie.getVal());
       movie.get().setSm(newMovie.getSm());
       movie.get().setPrice(newMovie.getPrice());
       movie.get().setPriceOut(newMovie.getPriceOut());
       movie.get().setFeatured(newMovie.getFeatured());
       

       TV updateTV = tRep.save(movie.get());

       return updateTV;



    }
}
