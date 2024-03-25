package com.h2sample;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.h2sample.entity.Course;
import com.h2sample.repo.CourseRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = H2SampleApplication.class)
class H2SampleApplicationTests {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepo repo;

	@Test
	public void findByIdTest() {
		Course findById = repo.findById(1002L);
		log.info("value from test method:\t" + findById.getName() + " " + findById.getId());
		assertEquals("Spring book", findById.getName());
		assertEquals(1002L, findById.getId());
	}
	
	@Test
	@DirtiesContext
	public void deleteById() {
		 repo.deleteById(1003L);
		assertNull( repo.findById(1003L));
//		 assertNotNull(repo.findById(1004L));
	}
	
	@Test
	@DirtiesContext
	public void save() {
		Course course=repo.findById(1L);
		assertEquals("micro book", course.getName());
		course.setName("nano book update");
		 repo.saveData(course);
		 Course course1=repo.findById(1L);
			assertEquals("nano book update", course1.getName());
	}
	
}
