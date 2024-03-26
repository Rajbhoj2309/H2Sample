package com.h2sample.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger log=LoggerFactory.getLogger(this.getClass());
	
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
	/**
	 * persist: This method is used to make a transient instance (newly created instance) persistent.
	 * It must be called in a transaction, and it assigns an identifier to the entity.
	 * associated with the persistence context and managed by the EntityManager
	 * so its stored in database
	 */
	public void playWithEntityManager() {
		Course course=new Course("Microservices");
		entityManager.persist(course);
		course.setName("Microservices updated");
		log.info("Microservices is updated: \t"+course.getClass());
	}
	/*
	 * The clear method is used to clear the persistence context, detaching all
	 * managed entities. It removes all entities from the persistence context,
	 * causing them to become detached. Any changes made to these entities after
	 * clearing the persistence context won't be tracked by the EntityManager. This
	 * method does not affect the database; it only affects the persistence context.
	 * =================FLUSH===========================================
	 * The flush method is used to synchronize the persistence context with the
	 * underlying database. It forces any changes (inserts, updates, deletes) that
	 * are pending in the persistence context to be executed immediately in the
	 * database. It doesn't commit the transaction; it just synchronizes the state
	 * of the persistence context with the database. clear removes all managed
	 * entities from the persistence context, while flush synchronizes changes from
	 * the persistence context to the database. clear does not affect the database;
	 * it only affects the persistence context. flush affects the database,
	 * executing any pending SQL statements. clear does not commit the transaction.
	 * flush doesn't commit the transaction either; it only synchronizes changes
	 * with the database.
	 */	
	public void playWithEntityManager2() {
		Course course1=new Course("NanoThings");
		entityManager.persist(course1);
		
		Course course2=new Course("New Book1");
		entityManager.persist(course2);
//		entityManager.flush();
		course2.setName("New Book1 updated");
		entityManager.flush();
		
//		entityManager.detach(course2);// no object track means no changes to store
//		entityManager.detach(course1);
		//or  not need to write detach again and again for every object
		// used clear method
		
//		entityManager.clear();
		entityManager.refresh(course2);
		
	//	course2.setName("NanoThings updated");
		log.info("Microservices is updated: \t"+course1.getClass());
		log.info("Microservices is updated: \t"+course2.getClass());
	}
	
	
}
