package basicClasses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/*
 * This class describes a order in the hotel
 * 
 * */

public class Order implements Serializable{
	//Data Members
	private int numOrder;
	private Guest guest;
	private Room room;
	private LocalDate date;
	private int numDays;
	
	//Constructors
	public Order(int numOrder, Guest guest, Room room, LocalDate date, int numDays) {
		super();
		this.numOrder = numOrder;
		setGuest(guest);
		setRoom(room);
		setDate(date);
		setNumDays(numDays);
	}
	
	//Get and set
	public int getNumOrder() {
		return numOrder;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	//To String
	@Override
	public String toString() {
		return "Order [numOrder=" + numOrder + ", guest=" + guest + ", room=" + room + ", date=" + date + ", numDays="
				+ numDays + "]";
	}

	//equals and hashCode
	@Override
	public int hashCode() {
		return Objects.hash(numOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return numOrder == other.numOrder;
	}
	
	//Functions
	
	//Calculate the final price
	public double calcPrice(double priceExtra)
	{
		if(getGuest() instanceof BussinessGuest)
			return ((double) (getNumDays() * Room.getStartPrice() + priceExtra - 
					BussinessGuest.getDiscountPercent()));
		return ((double) (getNumDays() * Room.getStartPrice() + priceExtra));
	}
}
