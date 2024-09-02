package com.addressBookSystem;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBooks;
    private static Scanner scanner = new Scanner(System.in);

    public AddressBookSystem() {
        addressBooks = new HashMap<>();
    }

    public static void main(String[] args) {
        AddressBookSystem system = new AddressBookSystem();
        system.run();
    }

    public void run() {
        while (true) {
            System.out.println("1. Add New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Search Contacts by City/State");
            System.out.println("4. View Contacts by City/State");
            System.out.println("5. Count Contacts by City/State");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addNewAddressBook();
                    break;
                case 2:
                    selectAddressBook();
                    break;
                case 3:
                    searchContactsByCityOrState();
                    break;
                case 4:
                    viewContactsByCityOrState();
                    break;
                case 5:
                    countContactsByCityOrState();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewAddressBook() {
        System.out.print("Enter the name for the new Address Book: ");
        String name = scanner.nextLine();
        if (addressBooks.containsKey(name)) {
            System.out.println("An Address Book with this name already exists.");
        } else {
            addressBooks.put(name, new AddressBook());
            System.out.println("Address Book '" + name + "' added successfully.");
        }
    }

    private void selectAddressBook() {
        System.out.print("Enter the name of the Address Book to select: ");
        String name = scanner.nextLine();
        AddressBook addressBook = addressBooks.get(name);

        if (addressBook != null) {
            manageContacts(addressBook);
        } else {
            System.out.println("Address Book not found.");
        }
    }

    private void manageContacts(AddressBook addressBook) {
        while (true) {
            System.out.println("1. Add New Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Sort Contacts by Name");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addNewContact(addressBook);
                    break;
                case 2:
                    addressBook.printContacts();
                    break;
                case 3:
                    editContact(addressBook);
                    break;
                case 4:
                    deleteContact(addressBook);
                    break;
                case 5:
                    addressBook.sortContactsByName();
                    break;
                case 6:
                	return;
 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addNewContact(AddressBook addressBook) {
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
        addressBook.addContact(contact);
        System.out.println("Contact added successfully.");
    }

    private void editContact(AddressBook addressBook) {
        System.out.print("Enter First Name of the contact to edit: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name of the contact to edit: ");
        String lastName = scanner.nextLine();

        if (!addressBook.editContact(firstName, lastName)) {
            System.out.println("Contact not found.");
        }
    }

    private void deleteContact(AddressBook addressBook) {
        System.out.print("Enter First Name of the contact to delete: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name of the contact to delete: ");
        String lastName = scanner.nextLine();

        if (!addressBook.deleteContact(firstName, lastName)) {
            System.out.println("Contact not found. Please check the name and try again.");
        }
    }

    private void searchContactsByCityOrState() {
        System.out.print("Enter City or State to search: ");
        String location = scanner.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContacts().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(location) || contact.getState().equalsIgnoreCase(location))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in the given city/state.");
        } else {
            result.forEach(System.out::println);
        }
    }
    private void viewContactsByCityOrState() {
        System.out.println("1. View Contacts by City");
        System.out.println("2. View Contacts by State");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                viewContactsByCity();
                break;
            case 2:
                viewContactsByState();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void viewContactsByCity() {
        System.out.print("Enter City to view contacts: ");
        String city = scanner.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByCity(city).stream())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in the city.");
        } else {
            result.forEach(System.out::println);
        }
    }

    private void viewContactsByState() {
        System.out.print("Enter State to view contacts: ");
        String state = scanner.nextLine();

        List<Contact> result = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByState(state).stream())
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("No contacts found in the state.");
        } else {
            result.forEach(System.out::println);
        }
    }
    
    private void countContactsByCityOrState() {
        System.out.println("1. Count Contacts by City");
        System.out.println("2. Count Contacts by State");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                countContactsByCity();
                break;
            case 2:
                countContactsByState();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void countContactsByCity() {
        System.out.print("Enter City to count contacts: ");
        String city = scanner.nextLine();

        long count = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByCity(city).stream())
                .count();

        System.out.println("Number of contacts in city '" + city + "': " + count);
    }

    private void countContactsByState() {
        System.out.print("Enter State to count contacts: ");
        String state = scanner.nextLine();

        long count = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactsByState(state).stream())
                .count();

        System.out.println("Number of contacts in state '" + state + "': " + count);
    }
}
