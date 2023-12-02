package main.java.storage;

import main.java.exceptions.ContactNotFound;
import main.java.exceptions.InvalidDataFound;
import main.java.models.Contact;

import java.util.Arrays;
import java.util.List;

public class AddressBookDao {
    SearchContact searchContactByName;
    SearchContact SearchContactByPhoneNumber;

    public AddressBookDao() {
        this.searchContactByName = new SearchContactByFirstName();
        this.SearchContactByPhoneNumber = new SearchContactByPhoneNumber();
    }

    /*
    We will be populating the contact in all the available trie data structure
     */
    public void addContact(Contact contact) {
        List<SearchContact> searchDirectories = getSearchDirectories();
        for(SearchContact searchContact : searchDirectories) {
            searchContact.addContact(contact);
        }
    }

    /*
    Method returns multiple contacts assuming different users have same first name
     */
    public List<Contact> getContactsByFirstName(String firstName) throws ContactNotFound, InvalidDataFound {
        Object contacts = searchContactByName.getContacts(firstName);
        if(contacts instanceof List) {
            List<Contact> contactsList = (List<Contact>) contacts;
            if(contactsList.isEmpty()) {
                throw new ContactNotFound();
            }
            return contactsList;
        }
        throw new InvalidDataFound();
    }

    /*
    Method returns single contact assuming phone number will be unique
     */
    public Contact getContactsByPhoneNumber(long phoneNumber) throws ContactNotFound, InvalidDataFound {
        Object contacts = SearchContactByPhoneNumber.getContacts(String.valueOf(phoneNumber));
        if(contacts instanceof List) {
            List<Contact> contactsList = (List<Contact>) contacts;
            if(contactsList.isEmpty()) {
                throw new ContactNotFound();
            }
            return contactsList.get(0);
        }
        throw new InvalidDataFound();
    }

    private List<SearchContact> getSearchDirectories() {
        return Arrays.asList(searchContactByName, SearchContactByPhoneNumber);
    }
}
