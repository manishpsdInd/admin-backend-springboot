package com.example.demo.profile.repository;

import com.example.demo.profile.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public Employee getByEmailId(String emailId);
	
}