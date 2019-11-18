package com.phonebook.service;

import java.util.Set;

import com.phonebook.io.Contact;
import com.phonebook.model.UserContact;

public interface ContactService {
	
	public Set<Contact> getContacts(final String firstName, final String lastName);
	public Set<UserContact> getContacts(final Contact requestContact);
	public Contact saveContact(final Contact requestContact);

}
