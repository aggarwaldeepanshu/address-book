package main.java;

import main.java.exceptions.ContactNotFound;
import main.java.exceptions.InvalidDataFound;
import main.java.exceptions.InvalidInputException;
import main.java.handlers.AddressBookHandler;
import main.java.models.Contact;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Driver {

    public static void main(String[] args) throws IOException {
        AddressBookHandler addressBookHandler = AddressBookHandler.getInstance();
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String input = bufferedReader.readLine();
        while (input != null) {
            try {
                runCommand(addressBookHandler, input);
            } catch (Exception e) {
                System.out.println(e);
            }
            input = bufferedReader.readLine();
        }

    }

    private static void runCommand(AddressBookHandler addressBookHandler, String input) throws ContactNotFound, InvalidDataFound, InvalidInputException {
        final String[] args = input.split(" ");
        final String commandType = args[0];
        if(commandType.equalsIgnoreCase("ADD")) {
            Contact contact = new Contact(args[1], args[2], args[3], Long.parseLong(args[4]));
            addressBookHandler.addContact(contact);
        } else if(commandType.equalsIgnoreCase("GET-BY-NAME")) {
            List<Contact> res = addressBookHandler.getContactByFirstName(args[1]);
            System.out.println();
            System.out.println("Contacts with first name " + args[1] + " found are:");
            for(Contact contact : res) {
                System.out.println(contact.toString());
            }
            System.out.println();
        } else if(commandType.equalsIgnoreCase("GET-BY-PHONE-NUMBER")) {
            Contact contact = addressBookHandler.getContactByPhoneNumber(Long.parseLong(args[1]));
            System.out.println();
            System.out.println("Contact with number " + args[1] + " found is:");
            System.out.println(contact.toString());
            System.out.println();
        } else {
            throw new InvalidInputException();
        }
    }
}
