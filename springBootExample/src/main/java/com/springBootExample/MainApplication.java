// This is a 100% Working Project demonstrating SpringBoot integration with H2 DB, CRUD Operations using RESTful services
// Details mentioned in SpringBootSampleProject document in Personal Folder

package com.springBootExample;	// All the other class should be within this package's sub-packages. so that they can be scanned.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

@EnableJpaAuditing		
// It is used to automatically persist the CreatedBy, CreatedDate, LastModifiedBy, and LastModifiedDate columns for any entity.
// Not mandatory

public class MainApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
}
