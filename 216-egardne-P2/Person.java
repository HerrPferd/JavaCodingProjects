
public class Person {
	private String firstName;
	private String lastName;
	private Address address;
	
	public Person(String fN, String lN, Address adrs) {
		firstName = fN;
		lastName = lN;
		address = adrs;
	}
	
	public Person() {
		firstName = null;
		lastName = null;
		address = null;
	}
	
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public Address getAddress() {return address;}
	
	public void setFirstName(String fN) {firstName = fN;}
	public void setLastName(String lN) {lastName = lN;}
	public void setAddress(Address adrs) {address = adrs;}
	
	public String toString() {
		String out = firstName + " " + lastName + " " + address.getStreetNo() + " " + address.getZipCode() + " " + address.getCity() + " " + address.getState();
		return out;
	}
}
