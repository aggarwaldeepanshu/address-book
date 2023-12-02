package main.java.handlers;

import main.java.exceptions.ContactNotFound;
import main.java.exceptions.InvalidDataFound;
import main.java.models.Contact;
import main.java.storage.AddressBookDao;

import java.util.List;

public class AddressBookHandler {
    AddressBookDao addressBookDao;

    public static AddressBookHandler getInstance() {
        AddressBookDao addressBookDao = new AddressBookDao();
        return new AddressBookHandler(addressBookDao);
    }

    public AddressBookHandler(AddressBookDao addressBookDao) {
        this.addressBookDao = addressBookDao;
    }

    public void addContact(Contact contact) {
        addressBookDao.addContact(contact);
    }

    public List<Contact> getContactByFirstName(String firstName) throws ContactNotFound, InvalidDataFound {
        return addressBookDao.getContactsByFirstName(firstName);
    }

    public Contact getContactByPhoneNumber(long phoneNumber) throws ContactNotFound, InvalidDataFound {
        return addressBookDao.getContactsByPhoneNumber(phoneNumber);
    }
}
