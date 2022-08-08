
public class Address {
	private String streetNumber;
	private int zipCode;
	private String city;
	private String state;
	
	public Address(String stNo, String cty, String ste, int zipCd) {
		streetNumber = stNo;
		zipCode = zipCd;
		city = cty;
		state = ste;
	}
	
	public Address() {
		streetNumber = null;
		zipCode = 0;
		city = null;
		state = null;
	}
	
	public String getStreetNo() {return streetNumber;}
	public int getZipCode() {return zipCode;}
	public String getCity() {return city;}
	public String getState() {return state;}
	
	public void setStreetNo(String stNo) {streetNumber = stNo;}
	public void setZipCode(int zipCd) {zipCode = zipCd;}
	public void setCity(String cty) {city = cty;}
	public void setState(String ste) {state = ste;}
}
