
package com.example.restapiassign2.models;

import org.springframework.data.annotation.Id;

/**
 *
 * @author kimberlycarpizo
 */
public class UseModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    
    public UseModel(){}

    public UseModel(String id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UseModel{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + '}';
    }
    
    
    
    
}
