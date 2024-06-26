package com.h2sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.h2sample.entity.Course;
import com.h2sample.entity.Student;
import com.h2sample.repo.CourseRepo;
import com.h2sample.repo.StudentRepository;

@SpringBootApplication
public class H2SampleApplication implements CommandLineRunner{

	@Autowired
	private CourseRepo repo;
	
	@Autowired
	private StudentRepository stdrepo;
	
	private Logger log=LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(H2SampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Course course = repo.findById(1001L);
//		log.info("Course 1001 -> {}", course);
		
//		repo.deleteById(1001L);
		
//		repo.saveData(new Course("micro book"));
//		repo.playWithEntityManager();
//		repo.playWithEntityManager2();
//		
//		stdrepo.findById(10L);
//		stdrepo.save(new Student("Kiran"));
		stdrepo.saveStudentWithPassport();
		
	}
	


}
