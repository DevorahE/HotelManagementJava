package lists;

import basicClasses.*;
import othersFunctions.FunctionsFiles;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/*
 * This class manages the orders list
 * 
 * **/

public class ListOrders {

	//Data members
	private LinkedList<Order> listOrder=new LinkedList<Order>();
	
	//Constructor
	public ListOrders() {
		super();
	}
	
	//Functions
	
	//Add a order
	public boolean addOrder(Order order)
	{
		return listOrder.add(order);
	}
	
	//Search by guest
	public Optional<Order> searchByGuest(Guest guest)
	{
		return listOrder.stream().filter(x -> x.getGuest().equals(guest)).findFirst();
	}
	
	//Search by room
	public Optional<Order> searchByRoom(Room room)
	{
		return listOrder.stream().filter(x -> x.getRoom().equals(room)).findFirst();
	}
	
	//Delete a order
	public int DeleteOrder(Guest guest)
	{
		Order order = searchByGuest(guest).get();
		int numRoom = order.getRoom().getNumRoom();
		listOrder.remove(order);
		return numRoom;
	}
	
	//Print by Guest
	public void printGuest(Guest guest)
	{
		Order order = searchByGuest(guest).get();
		System.out.println(order);
	}
	
	//Print by room
	public void printRoom(Room room)
	{	
		Optional<Order> roomOp= searchByRoom(room);
		if(roomOp.isPresent()) 
		{
			Order order = roomOp.get();
		System.out.println(order);
		}
	}
	
	//Print all orders
	public void printAll()
	{
		listOrder.forEach(System.out::println);
	}
	
	//Insert the order in a file
	public void writeOrderByNumDaysInFile(int numDay)
	{
		List<Order> listLocal= listOrder.stream().filter(x -> x.getNumDays() == numDay).toList();
		FunctionsFiles.writeInFile("orderByNumDays.txt", listLocal);
	}
	
	public void writeOrderByDateInFile(LocalDate date)
	{
		List<Order> listLocal= listOrder.stream().filter(x -> x.getDate().equals(date)).toList();
		FunctionsFiles.writeInFile("orderByDate.txt", listLocal);
	}
	
	public void readOrderByNumDaysFromFile()
	{
		FunctionsFiles.readFromFile("orderByNumDays.txt");
	}
	public void readOrderByDateFromFile()
	{
		FunctionsFiles.readFromFile("orderByDate.txt");
	}
}
