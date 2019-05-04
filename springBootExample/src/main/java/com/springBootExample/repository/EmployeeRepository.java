package com.springBootExample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springBootExample.model.Employee;


@Repository
//Inside <>, we mention the type of Entity & the type of the id
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findEmployeeByName(String name);	// This method name has to be in the Exact format 
													// 'getEmployeeByName' is absolutely wrong.
	
	@Query("SELECT e FROM Employee e WHERE e.name = :name1 OR e.name = :name2")
	public List<Employee> getParticularEmployees(@Param("name1") String name1, @Param("name2") String name2);
	// For queries with named parameters you need to use provide names for method parameters. Use @Param for query method parameters
	// Also, note that in the URL, don't use "" -> this works : localhost:8080/company/getParticularEmployees?name1=nitesh&name2=shobhit
}
