package com.pravin.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

/**
 * 
 * @author ppatil
 *
 */
@Entity
/**
 * Envers @Audited
 */
@Audited
@Table(name = "Employee")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "employee_name")
    private String name;
    @Column(name = "employee_mail")
    private String email;
    @Column(name = "employee_contact_no")
    private int contactNo;

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public int getContactNo() {
	return contactNo;
    }

    public void setContactNo(int contactNo) {
	this.contactNo = contactNo;
    }

}
