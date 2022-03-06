package booking.db;

import model.Airlines;
import model.Airports;
import model.Flights;
import model.Orders;
import model.Users;

public class testDataBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(Flights a: FetchFlights.getAllflights())
			System.out.println(a);
		
		for(Airlines b: FetchAirlines.getAllairlines())
			System.out.println(b);
		
		for(Orders c: FetchOrders.getAllorders())
			System.out.println(c);
		
		for(Airports d: FetchAirports.getAllairports())
			System.out.println(d);
		
		for(Users e: FetchUsers.getAllusers())
			System.out.println(e);
	}

}
