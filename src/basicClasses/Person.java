package basicClasses;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{
	//Data Members
	private String firstName;
	private String lastName;
	private int id;
	private Address address; 
	private String phone;
	
	//Constructor
	public Person(String firstName, String lastName, int id, Address address, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	
	//Get and set
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//equals and hashCode
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}

	//toString
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", address=" + address
				+ ", phone=" + phone + "]";
	}
	
}
