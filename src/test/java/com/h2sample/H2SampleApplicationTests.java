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


	
}
