package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.demo.entity.Student;
import com.demo.entity.User;
import com.demo.service.StudentService;
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    
    @GetMapping("/welcome")
    public String home2(Model model) {
    	return "welcome";
    }
    
    @GetMapping("/index")
    public String home(Model model) {
        return "index";
    }
   @GetMapping("/all_user")
    public String all_user(Model model) {
	   model.addAttribute("users", studentService.getAllUsers());
        return "all_user";
    }
    
    @GetMapping("/signup")
    public String CreateUserForm(Model model) {
    	User user= new User();
 	   model.addAttribute("users", user);
 	   return "signup";
    }
    
    @PostMapping("/all_user")
    public String saveUser(@ModelAttribute("user") User user) {
    	studentService.saveUser(user);
	   return "redirect:/all_user";
   }
    
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "all";
    }
    
    @GetMapping("/logout")
    public String home3() {
        return "logout";
    }
   
   @GetMapping("/add_student")
   public String CreateStudentForm(Model model) {
	   Student student= new Student();
	   model.addAttribute("students", student);
	   return "add_student";
   }
   @PostMapping("/all")
   public String saveStudent(@ModelAttribute("student") Student student) {
	   studentService.saveStudent(student);
	   return "redirect:/all";
   }
   
   @GetMapping("/all/edit/{id}")
   public String getStudentById(@PathVariable int id , Model model) {
	   model.addAttribute("student", studentService.getById(id));
	   return "edit_student";
   }
   
   @PostMapping("/all/edit/{id}")
   public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
	   Student existingStudent = studentService.getById(id);
	   existingStudent.setName(student.getName());
	   existingStudent.setEmail(student.getEmail());
	   existingStudent.setCourse(student.getCourse());
	   studentService.saveStudent(existingStudent);
	   return "redirect:/all";
	   
   }
   
   @GetMapping("/all/{id}")
   public String deleteById(@PathVariable int id)
   {
	   studentService.deleteById(id);
	   return "redirect:/all";
	   
   }
	   
   }

