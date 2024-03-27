package com.h2sample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String number;
	/**if we are not using mappedBy it will create a data duplicasy and it will create 3rd column of 
	 * student.id in passport table.
	 * if we are using mappedBy it will not create 3rd column for Student.id and data duplicasy gets
	 * avoided.
	*/
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;

	protected Passport() {
	}

	public Passport(String number) {
		super();
//		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	/**
	 * when does hibernate send updates to database
	 * Hibernate sends these changes to the database when the transaction is synchronized. 
	 * This generally happens at the end of a transaction. 
	 * However, calling EntityManager. flush() also triggers a transaction synchronization.
	 */
}
