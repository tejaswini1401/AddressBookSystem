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
		 while(true) {
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
		     
		     System.out.print("Do you want to add another contact? (yes/no): ");
	         String response = scanner.nextLine();
	         if (!response.equalsIgnoreCase("yes")) {
	             break;
	         }
		 }
	}
	 
	public boolean editContact(String firstName, String lastName) {
	     Optional<Contact> contactOpt = contacts.stream()
	    		 .filter(contact -> contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName))
	             .findFirst();

	     if (contactOpt.isPresent()) {
	    	 Contact contact = contactOpt.get();
	         Scanner scanner = new Scanner(System.in);

	         System.out.println("Editing contact: " + contact);
	         System.out.print("Enter new Address: ");
	         contact.setAddress(scanner.nextLine());
	         System.out.print("Enter new City: ");
	         contact.setCity(scanner.nextLine());
	         System.out.print("Enter new State: ");
	         contact.setState(scanner.nextLine());
	         System.out.print("Enter new Zip: ");
	         contact.setZip(scanner.nextLine());
	         System.out.print("Enter new Phone Number: ");
	         contact.setPhoneNumber(scanner.nextLine());
	         System.out.print("Enter new Email: ");
	         contact.setEmail(scanner.nextLine());

	         System.out.println("Contact updated successfully.");
	         return true;
	     } else {
	         System.out.println("Contact not found.");
	         return false;
	     }
	 }
	 
	 private static void editContact() {
		 System.out.print("Enter First Name of the contact to edit: ");
	     String firstName = scanner.nextLine();
	     System.out.print("Enter Last Name of the contact to edit: ");
	     String lastName = scanner.nextLine();

	     if (!addressBook.editContact(firstName, lastName)) {
	    	 System.out.println("Contact not found.");
	     }
	 }
	 
	 public boolean deleteContact(String firstName, String lastName) {
		 Iterator<Contact> iterator = contacts.iterator();
	     while (iterator.hasNext()) {
	     Contact contact = iterator.next();
	        if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
	            iterator.remove();
	        System.out.println("Contact deleted successfully.");
	        return true;
	        }
	     }
	     System.out.println("Contact not found.");
	     return false;
	 }
	 
	 private static void deleteContact() {
	        System.out.print("Enter First Name of the contact to delete: ");
	        String firstName = scanner.nextLine();
	        System.out.print("Enter Last Name of the contact to delete: ");
	        String lastName = scanner.nextLine();

	        if (!addressBook.deleteContact(firstName, lastName)) {
	            System.out.println("Contact not found. Please check the name and try again.");
	        }
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
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
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
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
		
		
	}
}
