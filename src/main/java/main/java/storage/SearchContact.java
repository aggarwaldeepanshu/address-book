package main.java.storage;

import main.java.exceptions.ContactNotFound;
import main.java.models.Contact;

import java.util.List;

public interface SearchContact {
    public void addContact(Contact contact);

    public Object getContacts(String firstName) throws ContactNotFound;
}
