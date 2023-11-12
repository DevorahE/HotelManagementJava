package othersFunctions;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

import basicClasses.*;
import lists.*;

/**
 *
 * @author דבורה
 *	This class manages the hotel. This class is Singleton.
 */

public class Hotel {

	//Singleton instance
	protected static Hotel instance;
	
	//The constructor is private because the class is singleton
	private Hotel(String name, Address address, String phone) {
		super();
		setName(name); 
		setAddress(address);
		setPhone(phone);
		this.listOrders = new ListOrders();
		this.listRoom = new ListRoom();
		this.listGuest = new ListGuest(listOrders);
		
		for(int i=0; i<30; i++)
		{
			Random r = new Random();
			int floor = i / 6 + 1;
			int level = r.nextInt(5)+1;
			listRoom.addRoom(new Room(i, floor, level, false));
		}
		
	}
	
	//This function create the class's instance 
	public static synchronized Hotel createInstance(String name, Address address, String phone)
	{		
		if(instance == null)
			return new Hotel(name, address, phone);
		
		return instance;
	}
	
	//Data members
	private String name;
	private Address address;
	private String phone;
	private ListGuest listGuest;
	private ListOrders listOrders;
	private ListRoom listRoom;
	//Counter guest, orders, rooms
	private int counterGuest = 0;
	private int counterOrder = 0;
	
	//Get and Set
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	//To String
	@Override
	public String toString() {
		return "Hotel [name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	
	//Add a order
	public boolean addOrder(String firstName, String lastName, int id, Address address, String phone, int level, int numDay, int bussinessGuestCode) 
	{
		Optional<Room> room = listRoom.SearchRoomByLevel(level);
		if(room.isEmpty()) 
		{
			System.out.println("There aren't rooms available with this level... Sorry, Try with a other level!");
			return false;
		}
		room.get().setActive(true);
		
		Guest guest;
		if(bussinessGuestCode > 0)
			guest = new BussinessGuest(new Person(firstName, lastName, id, address, phone), counterGuest++, bussinessGuestCode);
		else
			guest = new Guest(new Person(firstName, lastName, id, address, phone), counterGuest++);
		
		return listGuest.addCustomer(guest) &&
		listOrders.addOrder(new Order(counterOrder++, guest, room.get(), LocalDate.now(), numDay));
	}
	
	//Delete a order
	public void DeleteOrder(int id) 
	{
		Optional<Guest> guest = listGuest.seachGuestById(id);
		
		if(guest.isEmpty())
		{
			System.out.println("There aren't guests with this id...");
			return;
		}
		
		Optional<Order> order = listOrders.searchByGuest(guest.get());	
		if(guest.isEmpty())
		{
			System.out.println("There aren't order with this guest...");
			return;
		}
		
		order.get().getRoom().setActive(false);
		
		
		listOrders.DeleteOrder(guest.get());
		listGuest.removeGuest(guest.get());
		System.out.println("The cancelation is successed");
	}
	
	public Optional<Room> searchRoom(int level)
	{
		return listRoom.SearchRoomByLevel(level);
	}
	
	//get lists
	public ListGuest getListGuest() {
		return listGuest;
	}


	public ListOrders getListOrders() {
		return listOrders;
	}


	public ListRoom getListRoom() {
		return listRoom;
	}




}
