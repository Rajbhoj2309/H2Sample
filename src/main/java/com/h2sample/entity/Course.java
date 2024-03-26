package com.h2sample.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	@CreationTimestamp
    private LocalDateTime createdAt;
	
	@UpdateTimestamp
    private LocalDateTime updatedAt;

	public Course() {
	}
	public Course( String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
/*
 * @UpdateTimestamp and @CreationTimestamp are annotations provided by
 * Hibernate, which is commonly used with Spring ORM, for automatically managing
 * timestamp fields in entities. These annotations are typically used to
 * automatically update timestamp fields whenever an entity is updated
 * (@UpdateTimestamp) or created (@CreationTimestamp).
 */
//
/*
 * @CreationTimestamp:
 * 
 * This annotation is used to mark a field in an entity class to be
 * automatically populated with the timestamp of when the entity was first
 * persisted (i.e., created). When an entity instance is persisted to the
 * database for the first time, the field annotated with @CreationTimestamp is
 * populated with the current timestamp. This annotation is typically applied to
 * a java.util.Date or java.time.LocalDateTime field.
 */
//
//@UpdateTimestamp:
//
//This annotation is used to mark a field in an entity class to be automatically updated with the timestamp of when the entity was last updated.
//Whenever an entity instance is updated and the transaction is committed, the field annotated with @UpdateTimestamp is updated with the current timestamp.
//This annotation is also typically applied to a java.util.Date or java.time.LocalDateTime field.

