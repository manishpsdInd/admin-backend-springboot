package com.example.demo.profile.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.profile.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.profile.exception.ResourceAlreadyExists;
import com.example.demo.profile.exception.ResourceNotFound;
import com.example.demo.profile.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	private final Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()	{
		var list = employeeRepository.findAll();
		log.info("List of all active employees - {}", list.size());
		return list;
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name = "id") Long id)	{
		return ResponseEntity.ok(employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Employee not exist with id : " + id)));
	}
	
	@PostMapping("/employee")
	public long createEmployee(@RequestBody Employee employee)	{
		log.info("Creating a new employee");
		if(employee.getId()==0)	{
			
		}
		
		long id =0;
		try	{
			id = saveEmployee(employee);
			log.info("Employee created with ID - {}", id);
		} catch (DataIntegrityViolationException exception) {
			String errMsg = "Resource already exists in database";
			log.error(errMsg);
			throw new ResourceAlreadyExists(errMsg); 
		} catch (Exception exception) {
			String errMsg = "Resource already exists in database";
			log.error(errMsg);
			throw new ResourceAlreadyExists(errMsg); 
		}
		return id;
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody Employee employeeDetails)	{
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Employee not exist with id : " + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id)	{
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Employee not exist with id : " + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@Transactional
	private long saveEmployee(Employee employee) {
		return employeeRepository.save(employee).getId();
	}
	
}