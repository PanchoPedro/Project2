package model;

public class Orders {
	private String firstname;
	private String surname;
	private String email;
	private int flightid;
	private String source;
	private String destination;
	private String date_time;


	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	public Orders(String firstname, String surname, String email, int flightid, String source, String destination, String date_time) {
		super();
		this.firstname=firstname;
		this.surname=surname;
		this.email=email;
		this.flightid = flightid;
		this.source = source;
		this.destination = destination;
		this.date_time = date_time;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getFlightid() {
		return flightid;
	}


	public void setFlightid(int flightid) {
		this.flightid = flightid;
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


	public String getDate_time() {
		return date_time;
	}


	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}




	@Override
	public String toString() {
		return "Orders [firstname=" + firstname + ", surname=" + surname + ", email=" + email
				+ ", flightid=" + flightid + ", source=" + source + ", destination=" + destination + ", date_time="
				+ date_time + "]";
	}
	
	

	
	
	
	

}
