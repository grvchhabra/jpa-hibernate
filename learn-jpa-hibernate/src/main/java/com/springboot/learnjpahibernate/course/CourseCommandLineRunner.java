package com.springboot.learnjpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.save(new Course(1, "GCP", "Gaurav"));
		repository.save(new Course(2, "AWS", "Gaurav"));
		repository.save(new Course(3, "Azure", "Gaurav"));
		
		repository.deleteById(3l);
		
		System.out.println(repository.findById(1l));
		System.out.println(repository.findByAuthor("Gaurav"));
	}

}
