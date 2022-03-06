package model;

public class Airports {
	private int id;
	private String airport;
	
	
	public Airports() {
		// TODO Auto-generated constructor stub
	}
	
	//public Airports(int id, String airport) {
	public Airports(int id, String airport) {
		super();
		this.id = id;
		this.airport = airport;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	} 


	public String getAirport() {
		return airport;
	}


	public void setAirport(String airport) {
		this.airport = airport;
	}


	@Override
	public String toString() {
		return "Airports [id=" + id + ", airport=" + airport + "]";
		
	}
	
	
	
	
}
