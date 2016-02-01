package org.gradle;

import java.util.Date;

import org.gradle.mongodb.model.Record;
import org.gradle.mongodb.model.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Crawler implements CommandLineRunner {

	@Autowired
	private RecordRepository repository;
	

	public static void main(String[] args) {
		SpringApplication.run(Crawler.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();
		
		//Crawl files from system
		
				
		// save a couple of customers
		repository.save( new Record("c:/folder1/folder2/", 
							"MyResume",
							"Word Document", 
							"210KB",
							".doc",
							"Mohammad",
							(new Date()).toString()
						));
		repository.save( new Record("c:/f1/f2/", 
				"ReadMe",
				"Text", 
				"10KB",
				".txt",
				"Mohammad",
				(new Date()).toString()
			));

		// fetch all Records
		System.out.println("Recordds found with findAll():");
		System.out.println("-------------------------------");
		for (Record record : repository.findAll()) {
			System.out.println(record);
		}
		System.out.println();

		// fetch an individual Record
		System.out.println("Record found with findByName(\"MyResume\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByName("MyResume"));
		
		System.out.println("Record found with findByExtention(\".txt\"):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByExtension(".txt"));

		System.out.println("Records found with findByLocation(\"/f\"):");
		System.out.println("--------------------------------");
		for (Record record : repository.findByPath("/f") ) {
			System.out.println(record);
		}

	}

}