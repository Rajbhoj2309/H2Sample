package com.h2sample.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.h2sample.entity.Passport;
import com.h2sample.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager entityManager;

	public Student findById(Long id) {

		return entityManager.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() == null) {
			entityManager.persist(student);
		} else {
			entityManager.merge(student);
		}
		return student;
	}

	public void delete(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
		logger.info("delete student");
	}
	
	public void saveStudentWithPassport() {
		Passport p1=new Passport("7777777");
		entityManager.persist(p1);
		Student s1=new Student("Mike");
		s1.setPassport(p1);
	
		entityManager.persist(s1);
		logger.info("Data will be save from saveStudentWithPassport" +p1.getNumber());
	}
	

}
