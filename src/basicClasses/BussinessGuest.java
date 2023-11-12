package basicClasses;

import java.util.Objects;


/*
 * This class describes a business guest, and extends from The Guest class
 *
 *
 * */


public class BussinessGuest extends Guest {
	
	//Data members
	private static double discountPercent;
	private int bussinessGuestCode;
	
	//Constructor
	public BussinessGuest(Person guest, int numVisit, int bussinessGuestCode) {
		super(guest, numVisit);
		setBussinessGuestCode(bussinessGuestCode);
	}

	//Get and Set
	public static double getDiscountPercent() {
		return discountPercent;
	}

	public static void setDiscountPercent(double discountPercent) {
		BussinessGuest.discountPercent = discountPercent;
	}

	public int getBussinessGuestCode() {
		return bussinessGuestCode;
	}

	public void setBussinessGuestCode(int bussinessGuestCode) {
		this.bussinessGuestCode = bussinessGuestCode;
	}

	//toString
	@Override
	public String toString() {
		return "BussinessGuest [bussinessGuestCode=" + bussinessGuestCode + "]";
	}

	//equal and hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(bussinessGuestCode);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BussinessGuest other = (BussinessGuest) obj;
		return bussinessGuestCode == other.bussinessGuestCode;
	}
	
	
	

}
