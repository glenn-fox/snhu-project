package test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {
	
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService contacts = new ContactService();
		contacts.addContact(new Contact("1", "Glenn", "Fox", "5552327659", "1313 Mocking Bird Ln"));
		contacts.addContact(new Contact("2", "Vanessa", "Meyer", "5552328219", "221B Baker St"));
		contacts.addContact(new Contact("3", "Albanie", "Bolton", "5552230274", "2500 N River Rd"));
		contacts.addContact(new Contact("4", "Chuck", "Finly", "5556032525", "124 Conch Street"));
		
		contacts.updateFirstName("4", "Sam");
		assertTrue(contacts.getContact("4").getFirstName().equals("Sam"));
	}
	
	@Test
	void testContactServiceUpdateLastName() {
		ContactService contacts = new ContactService();
		contacts.addContact(new Contact("1", "Glenn", "Fox", "5552327659", "1313 Mocking Bird Ln"));
		contacts.addContact(new Contact("2", "Vanessa", "Meyer", "5552328219", "221B Baker St"));
		contacts.addContact(new Contact("3", "Albanie", "Bolton", "5552230274", "2500 N River Rd"));
		contacts.addContact(new Contact("4", "Chuck", "Finly", "5556032525", "124 Conch Street"));
		
		contacts.updateLastName("2", "Fox");
		assertTrue(contacts.getContact("2").getLastName().equals("Fox"));
	}

	@Test
	void testContactServiceUpdatePhoneNumber() {
		ContactService contacts = new ContactService();
		contacts.addContact(new Contact("1", "Glenn", "Fox", "5552327659", "1313 Mocking Bird Ln"));
		contacts.addContact(new Contact("2", "Vanessa", "Meyer", "5552328219", "221B Baker St"));
		contacts.addContact(new Contact("3", "Albanie", "Bolton", "5552230274", "2500 N River Rd"));
		contacts.addContact(new Contact("4", "Chuck", "Finly", "5556032525", "124 Conch Street"));
		
		contacts.updatePhoneNumber("3", "6820471937");
		assertTrue(contacts.getContact("3").getPhoneNumber().equals("6820471937"));
	}
	
	@Test
	void testContactServiceUpdate() {
		ContactService contacts = new ContactService();
		contacts.addContact(new Contact("1", "Glenn", "Fox", "5552327659", "1313 Mocking Bird Ln"));
		contacts.addContact(new Contact("2", "Vanessa", "Meyer", "5552328219", "221B Baker St"));
		contacts.addContact(new Contact("3", "Albanie", "Bolton", "5552230274", "2500 N River Rd"));
		contacts.addContact(new Contact("4", "Chuck", "Finly", "5556032525", "124 Conch Street"));
		
		contacts.updateAddress("1", "12 N Grand Ave");
		assertTrue(contacts.getContact("1").getAddress().equals("12 N Grand Ave"));
	}
	
	@Test
	void testContactServiceDelete() {
		ContactService contacts = new ContactService();
		contacts.addContact(new Contact("1", "Glenn", "Fox", "5552327659", "1313 Mocking Bird Ln"));
		contacts.addContact(new Contact("2", "Vanessa", "Meyer", "5552328219", "221B Baker St"));
		contacts.addContact(new Contact("3", "Albanie", "Bolton", "5552230274", "2500 N River Rd"));
		contacts.addContact(new Contact("4", "Chuck", "Finly", "5556032525", "124 Conch Street"));
		
		contacts.deleteContact("4");
		
		assertThrows(IllegalArgumentException.class, () ->{
			contacts.getContact("4");
		});
		
		assertThrows(IllegalArgumentException.class, () ->{
			contacts.deleteContact("4");
		});
		
	}
	
	@Test
	void testContactServiceUniqueIDs() {
		ContactService contacts = new ContactService();
		contacts.addContact(new Contact("1", "Glenn", "Fox", "5552327659", "1313 Mocking Bird Ln"));
		contacts.addContact(new Contact("2", "Vanessa", "Meyer", "5552328219", "221B Baker St"));
		contacts.addContact(new Contact("3", "Albanie", "Bolton", "5552230274", "2500 N River Rd"));
		contacts.addContact(new Contact("4", "Chuck", "Finly", "5556032525", "124 Conch Street"));
		
		assertThrows(IllegalArgumentException.class, () ->{
			contacts.addContact(new Contact("1", "Bob", "Ross", "5549170029", "1234 Some Address"));
		});
	}
}
