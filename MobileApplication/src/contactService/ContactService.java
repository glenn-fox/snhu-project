package contactService;


import java.util.*;

public class ContactService {
	// create list to store contacts
	List<Contact> contacts = new ArrayList<Contact>();
	
	public ContactService() {}
	
	public void addContact(Contact contact) {
		//check to make sure contactID for contact is not used
		for(int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contact.getContactID())) {
				throw new IllegalArgumentException("Contact ID already in use");
			}
		}
		this.contacts.add(contact);
	}
	
	// function to delete contact based off contactID
	public void deleteContact(String contactID) {
		for (int  i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contactID)) {
				this.contacts.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("No such contactID");
	}
	// functions to update first, last name, phone and address
	public void updateFirstName(String contactID, String newFirstName) {
		for (int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contactID)) {
				this.contacts.get(i).setFirstName(newFirstName);
			}
		}
	}
	
	public void updateLastName(String contactID, String newLastName) {
		for (int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contactID)) {
				this.contacts.get(i).setLastName(newLastName);
			}
		}
	}
	
	public void updatePhoneNumber(String contactID, String newPhoneNumber) {
		for (int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contactID)) {
				this.contacts.get(i).setPhoneNumber(newPhoneNumber);
			}
		}
	}
	
	public void updateAddress(String contactID, String newAddress) {
		for (int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contactID)) {
				this.contacts.get(i).setAddress(newAddress);
			}
		}
	}
	
	public Contact getContact(String contactID) {
		for (int i = 0; i < this.contacts.size(); i++) {
			if (this.contacts.get(i).getContactID().equals(contactID)) {
				return contacts.get(i);
			}
		}
		throw new IllegalArgumentException("Ivalid ContactID");
	}
	
	//For debugging purposes
//	public void showContacts() {
//		System.out.println("Stored Contacts:");
//		for(int i = 0; i < this.contacts.size(); i++) {
//			System.out.print(contacts.get(i).getContactID() + ", ");
//			System.out.print(contacts.get(i).getFirstName() + ", ");
//			System.out.print(contacts.get(i).getLastName() + ", ");
//			System.out.print(contacts.get(i).getPhoneNumber() + ", ");
//			System.out.println(contacts.get(i).getAddress());
//		}
//	}
}
