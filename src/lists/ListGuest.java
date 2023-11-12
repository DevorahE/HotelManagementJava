package lists;

import basicClasses.*;
import othersFunctions.FunctionsFiles;

import java.util.LinkedList;
import java.util.Optional;


/**
 * 
 * This class manages the guests list
 * 
 * */


public class ListGuest {


	//Data members
	private LinkedList<Guest> listGuest=new LinkedList<Guest>();
	private ListOrders listOrder;
	
	//Constructor
	public ListGuest(ListOrders listOrder) {
		super();
		this.listOrder = listOrder;
	}
	
	//Functions
	
	//This function add a guest in the hotel
	public boolean addCustomer(Guest guest)
	{
		return listGuest.add(guest);
	}
	
	//Functions Search
	public Optional<Guest> seachGuestById(int id)
	{
		return listGuest.stream().filter(x -> x.getGuest().getId() == id).findFirst();
	}
	
	public Optional<Guest> seachGuestByName(String firstName, String lastName)
	{
		return listGuest.stream().filter(x -> x.getGuest().getFirstName().equals(lastName) 
				&& x.getGuest().getLastName().equals(lastName)).findFirst();
	}
	
	public Optional<Guest> seachGuestByPhone(String phone)
	{
		return listGuest.stream().filter(x -> x.getGuest().getPhone().equals(phone)).findFirst();
	}
	
	//Remove a guest
	public boolean removeGuest(Guest guest)
	{
		if(listOrder.searchByGuest(guest).isPresent()) {
			System.out.println("You can't remove a guest because he has a order");
			return false;
		}
		
		return listGuest.remove(guest);
	}
	
	//Functions print
	public void printGuestById(int id)
	{
		Guest guest = seachGuestById(id).get();
		System.out.println(guest);
	}
	
	public void printGuestByName(String firstName, String LastName)
	{
		Guest guest = seachGuestByName(firstName, LastName).get();
		System.out.println(guest);
	}
	
	//Insert the guests in a file
	public void writeGuestInFile()
	{
		FunctionsFiles.writeInFile("guests.txt", listGuest);
	}
	
	public void readGuestFromFile()
	{
		FunctionsFiles.readFromFile("guests.txt");
	}
}
