package com.h2sample.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.h2sample.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class CourseRepo {

	@Autowired
	EntityManager entityManager;

	public Course findById(Long id) {

		return entityManager.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course find = findById(id);
		entityManager.remove(find);
	}
	
	public Course saveData(Course course) {
		if(course.getName() == null) {
			entityManager.persist(course);
		}else {
			entityManager.merge(course);
		}
		return course;
	}

}
