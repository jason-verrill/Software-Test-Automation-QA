package contact;

public class Contact {
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	// Class constructor requiring all variables to be filled on creation
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		if (phoneNumber == null || phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		
		// Call parser helper function to verify that the strings are within restricted limits
		parseString(id, 10, "id");
		parseString(firstName, 10, "firstName");
		parseString(lastName, 10, "lastName");
		parseString(address, 30, "address");
		
		// Set variables now that they have been verified
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	// Getters and Setters
	public String getID() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	// Reusable parser helper function that throws exception if restrictions are not met
	private void parseString(String input, int maxChar, String varName) {
		if (input == null || input.length() > maxChar) {
			throw new IllegalArgumentException("Invalid " + varName);
		}
	}
}