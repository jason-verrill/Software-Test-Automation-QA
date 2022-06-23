package contact;

import java.util.List;
import java.util.ArrayList;

// Contact service class manages multiple contacts within an array list
public class ContactService {
	private List<Contact> contactList;
	
	// Constructor Create empty Contact list on instance creation
	public ContactService() {
		contactList = new ArrayList<Contact>();
	}
	
	// Add a contact to the list. Must have unique ID.
	public void addContact(String id, String firstName, String lastName, String phoneNumber, String address) {
		// Verify specified id is unique
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == id) {
				throw new IllegalArgumentException("ID is not unique");
			}
		}
		
		Contact newContact = new Contact(id, firstName, lastName, phoneNumber, address);
		contactList.add(newContact);
	}
	
	// Search for and delete contact from list by id
	public void deleteContact(String contactID) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contactID) {
				contactList.remove(i);
			}
		}
	}
	
	// Search for contact by id and update name
	public void updateFirstName(String contactID, String newFirstName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contactID) {
				contactList.get(i).setFirstName(newFirstName);
			}
		}
	}
	
	// Search for contact by id and update name
	public void updateLastName(String contactID, String newLastName) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contactID) {
				contactList.get(i).setLastName(newLastName);
			}
		}
	}
	
	// Search for contact by id and update phone number
	public void updatePhoneNumber(String contactID, String newPhoneNumber) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contactID) {
				contactList.get(i).setPhoneNumber(newPhoneNumber);
			}
		}
	}
	
	// Search for contact by id and update address
	public void updateAddress(String contactID, String newAddress) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contactID) {
				contactList.get(i).setAddress(newAddress);
			}
		}
	}
	
	// Get a specific contact from the list by id. Currently used for JUnit testing and verification. 
	public Contact getContact(String contactID) {
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getID() == contactID) {
				return contactList.get(i);
			}
		}
		return null;
	}
	
	// Get the number of contacts in the list. Currently used for JUnit testing and verification. 
	public int getNumContacts() {
		return contactList.size();
	}
}