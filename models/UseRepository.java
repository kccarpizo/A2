
package com.example.restapiassign2.models;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author kimberlycarpizo
 */
public interface UseRepository extends MongoRepository<UseModel, String>{
    UseModel findByEmail(String email);
}
