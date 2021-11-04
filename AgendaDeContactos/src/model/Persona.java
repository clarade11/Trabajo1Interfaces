package model;

import java.time.LocalDate;

public class Persona {

	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private Integer postalCode;
	private LocalDate birthday;
	private Integer phone;

	public Persona(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.street = "";
		this.city = "";
		this.postalCode = 0;
		this.birthday = LocalDate.of(2010, 2, 2);
		this.phone = 900000000;
	}

	public Persona() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

}
