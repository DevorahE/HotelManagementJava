package lists;

import basicClasses.*;
import othersFunctions.FunctionsFiles;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/*
 * This class manages the rooms list
 * 
 * **/

public class ListRoom {
	//Data members
	private LinkedList<Room> listRooms=new LinkedList<Room>();

	//Constructors
	public ListRoom() {
		super();
	};
	
	//Functions
	
	//Add a room
	public boolean addRoom(Room room)
	{
		return listRooms.add(room);
	}
	
	//Search inactive room by level
	public Optional<Room> SearchRoomByLevel(int level)
	{
		return listRooms.stream().filter(x-> !x.isActive() && x.getLevel() == level).findFirst();
	}
	
	//Print functions
	public void printByNumRoom(int numRoom)
	{
		Room room = listRooms.stream().filter(x -> x.getNumRoom() == numRoom).findFirst().get();
		System.out.println(room);
	}
	
	public void printByFloor(int floor)
	{
		List<Room> listLocal= listRooms.stream().filter(x -> x.getFloor() == floor).toList();
		listLocal.forEach(System.out::println);
	}
	
	public void printByLevel(int level)
	{
		List<Room> listLocal= listRooms.stream().filter(x -> x.getLevel() == level).toList();
		listLocal.forEach(System.out::println);
	}
	
	public void printAll()
	{
		listRooms.forEach(System.out::println);
	}
	
	//Insert the room in a file
	public void writeRoomVacanInFile()
	{
		List<Room> listLocal= listRooms.stream().filter(x -> !x.isActive()).toList();
		FunctionsFiles.writeInFile("VacanRoom.txt", listLocal);
	}
	
	public void writeRoomClimbingInFile()
	{
		List<Room> listLocal= listRooms.stream().filter(x -> x.isActive()).toList();
		FunctionsFiles.writeInFile("ClimbingRoom.txt", listLocal);
	}
	//Read from a file
	public void readRoomVacanFromFile()
	{
		FunctionsFiles.readFromFile("VacanRoom.txt");
	}
	public void readRoomClimbingFromFile()
	{
		FunctionsFiles.readFromFile("ClimbingRoom.txt");
	}
}
