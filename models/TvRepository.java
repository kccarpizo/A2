
package com.example.restapiassign2.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kimberlycarpizo
 */
@Repository
public interface TvRepository extends MongoRepository<TV, String> {
    
}
