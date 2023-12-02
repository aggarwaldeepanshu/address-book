package main.java.storage;

import main.java.exceptions.ContactNotFound;
import main.java.models.Contact;
import main.java.models.Node;

public class SearchContactByPhoneNumber implements SearchContact {
    Node root;

    public SearchContactByPhoneNumber() {
        this.root = new Node();
    }

    /*
    Populates search by phone number trie with mobile number of given contact
     */
    public void addContact(Contact contact) {
        long phoneNumber = contact.getPhoneNumber();
        char[] numberChars = String.valueOf(phoneNumber).toCharArray();
        Node current = root;
        for(char number : numberChars) {
            Node[] childNodes = current.getChildNodes();
            int idx = number - '0';
            if(childNodes[idx] == null) {
                childNodes[idx] = new Node();
            }
            current = childNodes[idx];
        }
        current.getContacts().add(contact);
    }

    public Object getContacts(String phoneNumber) throws ContactNotFound {
        Node current = root;
        char[] numberChars = phoneNumber.toCharArray();
        for(char number : numberChars) {
            Node[] childNodes = current.getChildNodes();
            int idx = number - '0';
            if(childNodes[idx] == null) {
                throw new ContactNotFound();
            }
            current = childNodes[idx];
        }
        return current.getContacts();
    }
}
