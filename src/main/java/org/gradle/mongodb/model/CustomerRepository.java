package org.gradle.mongodb.model;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/** you dont have to create implementation on this Interface. 
 Spring Data MongoDB creates it on the fly when you run the application
 **/

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}