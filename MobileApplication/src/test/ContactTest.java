package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contactService.Contact;

class ContactTest {

	@Test
	void testContactGets() {
		Contact contact = new Contact("0000000001", "Glenn", "Fox", "5552240215", "2500 N River Rd");
		assertTrue(contact.getContactID().equals("0000000001"));
		assertTrue(contact.getFirstName().equals("Glenn"));
		assertTrue(contact.getLastName().equals("Fox"));
		assertTrue(contact.getPhoneNumber().equals("5552240215"));
		assertTrue(contact.getAddress().equals("2500 N River Rd"));
	}
	
	@Test
	void testContactIDValid() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("32524891807", "Glenn", "Fox", "5552240215", "2500 N River Rd");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, "Glenn", "Fox", "5552240215", "2500 N River Rd");
		});
	}
	
	@Test
	void testFirstNameValid() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Bobhadababyitsaboy", "Fox", "5552240215", "2500 N River Rd");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", null, "Fox", "5552240215", "2500 N River Rd");
		});
	}
	
	@Test
	void testLastNameValid() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", "abcdefghujklmnop", "5552240215", "2500 N River Rd");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", null, "5552240215", "2500 N River Rd");
		});
	}
	
	@Test
	void testPhoneNumberValid() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", "Fox", "55522402113", "2500 N River Rd");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", "Fox", "555224021", "2500 N River Rd");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", "Fox", null, "2500 N River Rd");
		});
	}

	@Test
	void testAddressValid() {
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", "Fox", "5552240215", "2500 N River Rd A Bunch of Words");
		});
		assertThrows(IllegalArgumentException.class, () ->{
			new Contact("0000000001", "Glenn", "Fox", "5552240215", null);
		});
	}
}
