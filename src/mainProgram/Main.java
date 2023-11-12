package mainProgram;

import java.util.Optional;
import java.util.Scanner;

import basicClasses.*;
import othersFunctions.Hotel;

public class Main {
	static Scanner in =new Scanner(System.in);
	public static Address enterAddress()
	{
		in.nextLine();
		System.out.println("Enter the street and number");
		String street = in.nextLine();
		int number = in.nextInt();
		in.nextLine();
		System.out.println("Enter the city:");
		String city = in.nextLine();
		
		System.out.println("Enter the country:");
		String country = in.nextLine();
		
		Address address = new Address(number, street, city, country);
		return address;
	}
	public static Hotel welcomeHotel()
	{
		System.out.println("Welcome to the platform HOTEL! \nEnter the name of the hotel:");
		String nameHotel = in.nextLine();
		
		Address address = enterAddress();
		
		System.out.println("Enter the hotel's phone:");
		String phone = in.nextLine();
		
		Hotel hotel = Hotel.createInstance(nameHotel, address, phone);
		return hotel;
	}
	
	public static void AddOrder(Hotel hotel)
	{
		System.out.println("Enter the first name, last name, id of the guest");
		String firstName =in.nextLine();
		in.nextLine();
		String lastName = in.nextLine();
		int id = in.nextInt();
		Address address = enterAddress();
		System.out.println("Enter your phone:");
		String phone = in.nextLine();
		System.out.println("Hello "+firstName+"! What level do you want?(1-5)");
		int level = in.nextInt();
		System.out.println("How many day?");
		int numDay = in.nextInt();
		System.out.println("Are you a bussiness guest? If you're enter you code, else enter -1");
		int bussinessGuestCode = in.nextInt();
		
		if(hotel.addOrder(firstName, lastName, id, address, phone, level, numDay, bussinessGuestCode))
			System.out.println("Your order added!");;
	}
	
	public static void printOrder(Hotel hotel)
	{
		System.out.println("To print all orders enter 1 \nTo print by guest enter 2 \nTo print by room enter 3");
		int choise = in.nextInt();
		switch (choise) {
		case 1: {
			hotel.getListOrders().printAll();
			break;
		}
		case 2:{
			System.out.println("Enter the guest id:");
			int id = in.nextInt();
			Optional<Guest> guest = hotel.getListGuest().seachGuestById(id);
			if(guest.isPresent())
				hotel.getListOrders().printGuest(guest.get());
			break;
		}
		case 3:{
			System.out.println("Enter the level room:");
			int level = in.nextInt();
			Optional<Room> room = hotel.getListRoom().SearchRoomByLevel(level);
			if(room.isPresent())
				hotel.getListOrders().printRoom(room.get());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choise);
		}
	}
	
	public static void deleteOrder(Hotel hotel)
	{
		System.out.println("Enter your id:");
		int id = in.nextInt();
		hotel.DeleteOrder(id);
	}
	
	public static void fileRooms(Hotel hotel)
	{
		System.out.println("To file with vacans room enter 1 \nTo file with climbing room enter 2");
		int choise = in.nextInt();
		switch (choise) {
		case 1: {
			hotel.getListRoom().writeRoomVacanInFile();
			hotel.getListRoom().readRoomVacanFromFile();
			break;
		}
		case 2: {
			hotel.getListRoom().writeRoomClimbingInFile();
			hotel.getListRoom().readRoomClimbingFromFile();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choise);
		}
	}
	
	public static void main(String[] args) {
		Hotel hotel = welcomeHotel();
		
		while(true)
		{
			System.out.println("Welcome to "+hotel.getName()+" hotel \nTo print details hotel enter 1"
					+ "\nTo add order enter 2"
					+ "\nTo delete order enter 3"
					+ "\nTo print order enter 4"
					+"\nTo receive a file with room enter 5"
					+"\nTo print details customers enter 6"
					);
			int choise = in.nextInt();
			
			switch (choise) {
			case 1: {
				System.out.println(hotel);
				break;
			}
			case 2: {
				AddOrder(hotel);
				break;
			}
			case 3: {
				deleteOrder(hotel);	
				break;
						}
			case 4: {
				printOrder(hotel);
				break;
			}
			case 5: {
				fileRooms(hotel);
				break;
			}
			case 6: {
				hotel.getListGuest().writeGuestInFile();
				hotel.getListGuest().readGuestFromFile();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choise);

			}
		}
	}

}
