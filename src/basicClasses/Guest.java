package basicClasses;

import java.io.Serializable;
import java.util.Objects;


/*
 * 
 * This class describes guest in the hotel
 * 
 * */

public class Guest implements Serializable{

	//Data members
	private Person guest;
	private int numVisit;
	
	//Constructor
	public Guest(Person guest, int numVisit) {
		super();
		setGuest(guest);
		setNumVisit(numVisit);
	}
	
	//Get and Set
	public Person getGuest() {
		return guest;
	}
	
	public void setGuest(Person guest) {
		this.guest = guest;
	}
	
	public int getNumVisit() {
		return numVisit;
	}
	
	public void setNumVisit(int numVisit) {
		this.numVisit = numVisit;
	}
	
	//toString
	@Override
	public String toString() {
		return "Guest [guest=" + guest + ", numVisit=" + numVisit + "]";
	}

	//equal and hashCode
	@Override
	public int hashCode() {
		return Objects.hash(guest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest other = (Guest) obj;
		return Objects.equals(guest, other.guest);
	}
	
	
	
	
	
	
	
}
