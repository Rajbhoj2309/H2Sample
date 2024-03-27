package com.h2sample;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.h2sample.entity.Passport;
import com.h2sample.entity.Student;
import com.h2sample.repo.StudentRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentRepositoryTest {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentRepository repository;
	
	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	public void retrivesStudentPassportDetails() {
		Student find = em.find(Student.class, 1);
		Passport passport = find.getPassport();
		log.info("Student -> {} ", find );
		log.info("Student -> {} ", find.getPassport());
	}
}
