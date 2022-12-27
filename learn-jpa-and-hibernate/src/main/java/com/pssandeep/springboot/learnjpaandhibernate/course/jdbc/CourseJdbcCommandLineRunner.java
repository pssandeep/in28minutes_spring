package com.pssandeep.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pssandeep.springboot.learnjpaandhibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

	@Autowired
	private CourseJdbcRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Command Line Runner"); 
		repository.insert(new Course(1,"TEST1","AUTHOR1"));
		repository.insert(new Course(2,"TEST2","AUTHOR2"));		
		repository.insert(new Course(3,"TEST3","AUTHOR3"));
		repository.deleteById(2);
		System.out.println(repository.findByID(1));
		System.out.println(repository.findByID(3));
		System.out.println(repository.findAll());
		
	}
	
}
