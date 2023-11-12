package basicClasses;


import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

/*
 * This class describes a room in the hotel
 * 
 * */

public class Room implements Serializable{

	//Data Members
	private static double startPrice;
	
	private int numRoom;
	private int floor;
	private int level;
	private boolean isActive;
	
	//Constructor
	public Room(int numRoom, int floor, int level, boolean isActive) {
		super();
		this.numRoom = numRoom;
		setFloor(floor);
		setLevel(level);
		setActive(isActive);
		
	}

	public static double getStartPrice() {
		return startPrice;
	}

	public static void setStartPrice(double startPrice) {
		Room.startPrice = startPrice;
	}

	//This field is only to read
	public int getNumRoom() {
		return numRoom;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	//toString
	@Override
	public String toString() {
		return "Room [numRoom=" + numRoom + ", floor=" + floor + ", level=" + level + ", isActive=" + isActive + "]";
	}

	//equal and hashCode
	@Override
	public int hashCode() {
		return Objects.hash(numRoom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return numRoom == other.numRoom;
	}
}

