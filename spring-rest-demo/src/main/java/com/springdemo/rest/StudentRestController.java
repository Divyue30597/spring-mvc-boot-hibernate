package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	//define @PostConstruct to load the data only once
	@PostConstruct  
	public void nloadData() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Poornima","Patel"));
		theStudents.add(new Student("Tom","Chi"));
		theStudents.add(new Student("Tomchi","Sharma"));
		
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		// just index into the list
		
		//check the studentId against the list size
		if ((studentId >= theStudents.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student Not Found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	//Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		//create a studentErrorResponse
		
		StudentErrorResponse error = new StudentErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		//return responseEntity
	
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
}







