package com.egen.assessment.user.domain;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

/**
 * Domain entity for representing a {@link User}.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@Entity
@Table(name = "user")
@DynamicUpdate
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	/** Unique identifier for a user. */
	private UUID userId;
	/** First name of a user. */
	private String firstName;
	/** Last name of a user. */
	private String lastName;
	/** Middle name of a user. */
	private String middleName;
	/** Age of a user. */
	private String age;
	/** Gender of a user. */
	private Gender gender;
	/** Phone number of a user. */
	private String phone;
	/** Zip of a user. */
	private String zip;

	public User() {
	}

	/**
	 * Returns the user unique identifier.
	 *
	 * @return GUID for user
	 */
	@Id
	@Column(name = "user_id")
	@org.hibernate.annotations.Type(type = "uuid-char")
	@GeneratedValue
	public UUID getUserId() {
		return userId;
	}

	/**
	 * Sets the specified {@code userId}.
	 *
	 * @param userId
	 */
	protected void setUserId(UUID userId) {
		this.userId = userId;
	}

	/**
	 * Returns {@code firstName} for the user.
	 */
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the specified {@code firstName} for the user.
	 *
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Returns {@code lastName} of the user.
	 */
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the specified {@code lastName} for the user.
	 *
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Returns {@code middleName} of the user.
	 */
	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the specified {@code middleName} for the user.
	 *
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Returns {@code phone} of the user.
	 */
	@Column(name = "phone")
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the specified {@code phone} for the user.
	 *
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns {@code age} for the user.
	 */
	@Column(name = "age")
	public String getAge() {
		return age;
	}

	/**
	 * Sets the specified {@code age} for the user.
	 *
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Returns {@code gender} for the user.
	 */
	@Column(name = "gender")
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the specified {@code gender} for the user.
	 *
	 * @param gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	/**
	 * Returns {@code zip} for the user.
	 */
	@Column(name = "zip")
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the specified {@code zip} for the user.
	 *
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "[User firstName:" + firstName + ", lastName: " + lastName + ", middleName: " + middleName + ", gender: "
				+ gender + ", phone: " + phone + ", zip: " + zip + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	/**
	 * Enum constants defining the available genders.
	 */
	public enum Gender {M,F}
}
