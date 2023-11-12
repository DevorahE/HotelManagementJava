package basicClasses;

import java.io.Serializable;

public class Address implements Serializable{
	
	private int num;
	
	private String street;
	
	private String city;
	
	private String country;
	
	public Address() {}
	
	public Address(int num, String street, String city, String country) {
		setNum(num);
		setCity(city);
		setStreet(street);
		setCountry(country);
	}
	
	public void setDetails(int num, String street, String city, String country) {
		setNum(num);
		setCity(city);
		setStreet(street);
		setCountry(country);
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return num+" "+street+" "+city+" "+country;
	}
	
	public void print() {
		System.out.println(this);
	}
}
