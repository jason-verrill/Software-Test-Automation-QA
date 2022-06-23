package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.Contact;

// Used to test the Contact Class
class ContactTest {

	@Test
	void testContactClass() {
		// Create valid contact
		Contact successContact = new Contact("1", "John", "Smith", "0123456789", "12 Park Rd");
		
		// ID must be less than 10 characters and not null
		assertTrue(successContact.getID().length() < 10);
		assertTrue(successContact.getID() != null);
		
		// First name must be less than 10 characters and not null
		assertTrue(successContact.getFirstName().length() < 10);
		assertTrue(successContact.getFirstName() != null);
		
		// Last name must be less than 10 characters and not null
		assertTrue(successContact.getLastName().length() < 10);
		assertTrue(successContact.getLastName() != null);
		
		// Phone number must exactly 10 characters and not null
		assertTrue(successContact.getPhoneNumber().length() == 10);
		assertTrue(successContact.getPhoneNumber() != null);
		
		// Address must be less than 30 characters and not null
		assertTrue(successContact.getAddress().length() < 30);
		assertTrue(successContact.getAddress() != null);
	}
}
