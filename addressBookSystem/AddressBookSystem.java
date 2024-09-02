package com.addressBookSystem;
import java.util.*;

public class AddressBookSystem {
	
	private List<Contact> contacts = new ArrayList<>();
	
	private static AddressBookSystem addressBook = new AddressBookSystem();
	
	static Scanner scanner = new Scanner(System.in);
			
	public void addContacts(Contact contact) {
		contacts.add(contact);
	}
	
	 private static void addNewContact() {
		 System.out.print("Enter First Name: ");
	     String firstName = scanner.nextLine();
	     System.out.print("Enter Last Name: ");
	     String lastName = scanner.nextLine();
	     System.out.print("Enter Address: ");
	     String address = scanner.nextLine();
	     System.out.print("Enter City: ");
	     String city = scanner.nextLine();
	     System.out.print("Enter State: ");
	     String state = scanner.nextLine();
	     System.out.print("Enter Zip: ");
	     String zip = scanner.nextLine();
	     System.out.print("Enter Phone Number: ");
	     String phoneNumber = scanner.nextLine();
	     System.out.print("Enter Email: ");
	     String email = scanner.nextLine();

	     Contact contact = new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
	     addressBook.addContacts(contact);
	     System.out.println("Contact added successfully.");
	}
	
	public void printContacts() {
		for(Contact contact: contacts) {
			System.out.println(contact);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System Program");	
		
		
		while (true) {
            System.out.println("1. Add New Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    addressBook.printContacts();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
		
		
	}
}
