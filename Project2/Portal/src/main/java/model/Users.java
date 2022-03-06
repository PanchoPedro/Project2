package model;

public class Users {
	private int id;
	private String firstname;
	private String surname;
	private String email;
	private String phone;
	private String dateofbirth;
	private String password;
	private String type;
	
	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String firstname, String surname, String email, String phone, String dateofbirth, String password, String type) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.dateofbirth = dateofbirth;
		this.password = password;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", email=" + email + ", phone="
				+ phone + ", dateofbirth=" + dateofbirth + ", password=" + password + ", type=" + type + "]";
	}

	
	
	

}
