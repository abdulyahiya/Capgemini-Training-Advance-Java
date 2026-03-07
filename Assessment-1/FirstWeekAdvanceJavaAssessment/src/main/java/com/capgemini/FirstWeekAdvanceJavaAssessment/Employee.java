/**
 * 
 */
package com.capgemini.FirstWeekAdvanceJavaAssessment;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 */
@Entity
@Table(name ="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private IDCard idCard;

	/**
	 * 
	 */
	public Employee() {
		super();
	}

	/**
	 * @param name
	 * @param email
	 */
	public Employee(String name, String email,IDCard idCard) {
		super();
		this.name = name;
		this.email = email;
		this.idCard=idCard;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idCard
	 */
	public IDCard getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(IDCard idCard) {
		this.idCard = idCard;
	}

	/**
	 * 
	 */
	

	

}
