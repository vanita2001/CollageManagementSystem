package com.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Student;
import com.demo.entity.User;
import com.demo.service.StudentService;

@Service
public class ServiceImpl implements StudentService {
	
	@Autowired
	com.demo.repository.StudentRepository StudentRepository;
	@Autowired
	com.demo.repository.UserRepository UserRepository;
	
	@Override
	public List<Student> getAllStudents() {
	    List<Student> list= StudentRepository.findAll();
	    return list;
	}
	@Override
	public Student saveStudent(Student student) {
		return StudentRepository.save(student);
	}

	@Override
	public Student getById(int id) {
		
		return StudentRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		StudentRepository.deleteById(id);
		
	}
		@Override
		public List<User> getAllUsers() {
			List< User> list1= UserRepository.findAll();
		    return list1;
		}

		@Override
		public User saveUser(User user) {
			return UserRepository.save(user);
		}
		
	}
	