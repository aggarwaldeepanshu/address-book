package main.java.models;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Node[] childNodes;
    List<Contact> contacts;

    public Node() {
        this.childNodes = new Node[26];
        this.contacts = new ArrayList<>();
    }

    public Node[] getChildNodes() {
        return childNodes;
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
