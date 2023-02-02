package com.springboot.learnjpahibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.springboot.learnjpahibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course selectById(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		entityManager.remove(entityManager.find(Course.class, id));
	}
	
}
