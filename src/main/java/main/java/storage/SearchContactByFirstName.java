package main.java.storage;

import main.java.exceptions.ContactNotFound;
import main.java.models.Contact;
import main.java.models.Node;

public class SearchContactByFirstName implements SearchContact{
    Node root;

    public SearchContactByFirstName() {
        this.root = new Node();
    }

    /*
    Populates search by name trie with first name of given contact
     */
    public void addContact(Contact contact) {
        String firstName = contact.getFirstName();
        char[] firstNameChars = firstName.toLowerCase().toCharArray();
        Node current = root;
        for(char letter : firstNameChars) {
            Node[] childNodes = current.getChildNodes();
            int idx = letter - 'a';
            if(childNodes[idx] == null) {
                childNodes[idx] = new Node();
            }
            current = childNodes[idx];
        }
        current.getContacts().add(contact);
    }

    public Object getContacts(String firstName) throws ContactNotFound {
        Node current = root;
        char[] firstNameChars = firstName.toLowerCase().toCharArray();
        for(char letter : firstNameChars) {
            Node[] childNodes = current.getChildNodes();
            int idx = letter - 'a';
            if(childNodes[idx] == null) {
                throw new ContactNotFound();
            }
            current = childNodes[idx];
        }
        return current.getContacts();
    }
}
