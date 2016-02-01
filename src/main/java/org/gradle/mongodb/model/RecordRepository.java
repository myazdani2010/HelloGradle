package org.gradle.mongodb.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


/** you dont have to create implementation on this Interface. 
Spring Data MongoDB creates it on the fly when you run the application
**/


public interface RecordRepository 
	extends MongoRepository<Record, String>{

	// method name findByXxx(): Xxx should match your attribute in Model class
    public Record findByName(String firstName);
    public Record findByExtension(String lastName);
    public List<Record> findByPath(String lastName);
}
