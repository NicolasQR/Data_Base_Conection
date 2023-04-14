package model;

public class Users {

	private int age;
	private String genre;
	private String ocupation;
	private String zip;
	
	public Users(int age, String genre, String ocupation, String zip) {
		this.setAge(age);
		this.setGenre(genre);
		this.setOcupation(ocupation);
		this.setZip(zip);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
