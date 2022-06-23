package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contact.ContactService;

// Tests the ContactService class
class ContactServiceTest {
	@Test
	void testContactServiceClass() {
		// Create a new Contact Service instance and add two successful contacts
		ContactService contactService = new ContactService();
		contactService.addContact("1", "John", "Smith", "0123456789", "12 Park Rd");
		contactService.addContact("2", "Jane", "Smith", "0123456789", "12 Park Rd");
		
		// Create a contact that should fail and throw an exception because it does not have a unique id
		Throwable idNotUniqueException = assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("1", "Anonymous", "Smith", "0123456789", "12 Park Rd");
		});
		
		assertEquals("ID is not unique", idNotUniqueException.getMessage());
		
		// Check to make sure contacts were added by checking the number of contacts in the list
		assertTrue(contactService.getNumContacts() == 2);
		
		// Delete contact and check to make sure it was deleted (should only be 1 contact after deletion)
		contactService.deleteContact("2");
		assertTrue(contactService.getNumContacts() == 1);
		
		// Update contact fields and verify changes
		contactService.updateFirstName("1", "Jim");
		contactService.updateLastName("1", "Bakerson");
		contactService.updatePhoneNumber("1", "5555555555");
		contactService.updateAddress("1", "555 Fivers Rd");
		
		assertTrue(contactService.getContact("1").getFirstName() == "Jim");
		assertTrue(contactService.getContact("1").getLastName() == "Bakerson");
		assertTrue(contactService.getContact("1").getPhoneNumber() == "5555555555");
		assertTrue(contactService.getContact("1").getAddress() == "555 Fivers Rd");
	}

}
