package model;

public class Flights {
	private int id;
	private String source;
	private String destination;
	private String airline;
	private int price;
	private String date_time;
	private int seats;
	private int takenseats;
	
	public Flights() {
		// TODO Auto-generated constructor stub
	}
	
	public Flights(int id, String source, String destination, String airline, int price, String date_time, int seats, int takenseats) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.airline = airline;
		this.price = price;
		this.date_time = date_time;
		this.seats = seats;
		this.takenseats=takenseats;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	



	public int getTakenseats() {
		return takenseats;
	}

	public void setTakenseats(int takenseats) {
		this.takenseats = takenseats;
	}

	@Override
	public String toString() {
		return "flights [id=" + id + ", source=" + source + ", destination=" + destination + ", airline=" + airline
				+ ", price=" + price + ", date_time=" + date_time + ", seats=" + seats + ", takenseats=" + takenseats + "]";
	}
	

}
