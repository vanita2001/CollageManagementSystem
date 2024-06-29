package com.demo.service;

import java.util.List;

import com.demo.entity.Student;
import com.demo.entity.User;



public interface StudentService {
	public List <Student> getAllStudents(); 
	
	public List <User> getAllUsers();
	
	public Student saveStudent(Student student); //save student data
	
	public Student getById(int id); //get student from its id
	
	public void deleteById(int id); 
		
	public User saveUser(User user);
		
	}


