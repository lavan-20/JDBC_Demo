package com.lav.org.dto;

public class SalesPerson implements DataTransferObject{

	
	private int salespersonId;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	@Override
	public String toString() {
		return "SalesPerson [salespersonId=" + salespersonId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", address=" + address + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + "]";
	}
	
	
	public SalesPerson(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getSalespersonId() {
		return salespersonId;
	}
	public void setSalespersonId(int salespersonId) {
		this.salespersonId = salespersonId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
