
package com.example.restapiassign2.controller;

import com.example.restapiassign2.CustomResponse;
import com.example.restapiassign2.models.UseModel;
import com.example.restapiassign2.services.UseService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author kimberlycarpizo
 */
@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class UseController {
    @Autowired
    private UseService userService;

   @GetMapping("/users")
    public ResponseEntity getUsers()
    {

        var customResponse = new CustomResponse( " All users ", userService.getUsers());

        return new ResponseEntity( customResponse, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity getUsers(@PathVariable("id") String id)
    {

     var customResponse = new CustomResponse( " User : " + id, Collections.singletonList(userService.getUser(id)));

     return new ResponseEntity( customResponse, HttpStatus.OK);

    }

    @PostMapping(value = "/users", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity createUsers(@RequestBody UseModel user)
    {


     var response = new CustomResponse( "User created", Collections.singletonList(userService.addUser(user)));

     return new ResponseEntity( response, HttpStatus.OK);

    }
}
