package com.example.demo.profile.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
*/
@Entity
@Table(name="employees")
public class Employee	{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "employees_id_seq")
    @SequenceGenerator(name = "employees_id_seq", sequenceName = "employees_id_gen",  allocationSize = 1)
	@Column(name="emp_id")
	private long id;
	
	@Column(nullable = false, name="first_name")
	private String firstName;
	
	@Column(nullable = false, name="last_name")
	private String lastName;
	
	@Column(nullable = false, name="email_id", unique = true)
	private String emailId;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + "]";
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}