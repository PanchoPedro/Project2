package model;

public class Airlines {
	private int id;
	private String airline;
	
	public Airlines() {
		// TODO Auto-generated constructor stub
	}

	public Airlines(int id, String airline) {
		super();
		this.id = id;
		this.airline = airline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	@Override
	public String toString() {
		return "Airlines [id=" + id + ", airline=" + airline + "]";
	}
	
	

}
