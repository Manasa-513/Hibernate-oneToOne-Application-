package com.onetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passport ")
public class Passport 
{
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="pst_id")	
 private int id;
	@Column(name="pst_num")		
 private int passportnum;
	@OneToOne
	@JoinColumn(name="person_id")
	private  Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassportnum() {
		return passportnum;
	}
	public void setPassportnum(int passportnum) {
		this.passportnum = passportnum;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Passport(int id, int passportnum, Person person) {
		super();
		this.id = id;
		this.passportnum = passportnum;
		this.person = person;
	}
	public Passport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
