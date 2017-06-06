package com.egen.assessment.user.resource;


import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.egen.assessment.user.domain.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * REST resource representation of a {@link User}.
 *
 * @since 1.0.0
 * @author Gowrisankar
 */
@JsonPropertyOrder({"userId","firstName", "middleName", "lastName", "age", "gender", "phone", "zip"})
public class UserResource {

	/** Unique identifier for a user. */
	private UUID _userId;	
	/** First name of a user. */
	private String _firstName;	
	/** Last name of a user. */
	private String _lastName;	
	/** Middle name of a user. */
	private String _middleName;	
	/** Mobile number of a user. */
	private String _age;
	/** Mobile number of a user. */
	private User.Gender _gender;
	/** Mobile number of a user. */
	private String _phone;	
	/** Mobile number of a user. */
	private String _zip;


	@JsonProperty("userId")
	public UUID getUserId() {
		return _userId;
	}

	public void setUserId(UUID _usrId) {
		this._userId = _usrId;
	}
	
	@JsonProperty("firstName")
	@NotNull(message = "First Name cannot be null")
	@Pattern(regexp = "[A-Za-z]+", message = "First name must be alphabet")
	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@JsonProperty("lastName")
	@NotNull(message = "Last Name cannot be null")
	@Pattern(regexp = "[A-Za-z]+", message = "Last name must be alphabet")
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@JsonProperty("middleName")
	@Pattern(regexp = "[A-Za-z]+", message = "Middle name must be alphabet")
	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	@JsonProperty("phone")
	@NotNull(message = "Phone number cannot be null")
	@Pattern(regexp = "^[2-9]{1}[0-9]{9}$", message = "Phone number must be 10 digit positive number")
	public String getPhone() {
		return _phone;
	}

	public void setPhone(String _mobileNumber) {
		this._phone = _mobileNumber;
	}
	
	@JsonProperty("age")
	@NotNull(message = "Age cannot be null")
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "Age must be non-zero positive number")
	public String getAge() {
		return _age;
	}

	public void setAge(String _age) {
		this._age = _age;
	}

	@JsonProperty("gender")
	@NotNull(message = "Gender cannot be null")
	public User.Gender getGender() {
		return _gender;
	}

	public void setGender(User.Gender _gender) {
		this._gender = _gender;
	}

	@JsonProperty("zip")
	@Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code must be five-digit or nine-digit (called ZIP+4) formats. Example: 12345 and 12345-6789")
	public String getZip() {
		return _zip;
	}

	public void setZip(String _zip) {
		this._zip = _zip;
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == this) {
			return true;
		}
		return obj instanceof UserResourceJsonTest
			&& Objects.equals(_userId, ((UserResource) obj)._userId);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(_userId);
	}

}
