package com.addressBookSystem;

import java.util.*;

public class AddressBook {

    private Set<Contact> contacts;

    public AddressBook() {
        contacts = new HashSet<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
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
            return false;
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
        return false;
    }

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
