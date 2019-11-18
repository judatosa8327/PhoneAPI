package com.phonebook.config;

import java.util.List;

import com.phonebook.io.Contact;
import com.phonebook.io.ContactInfo;
import com.phonebook.model.UserContact;
import com.phonebook.model.UserContactInfo;

public class ConfigurationTest {

	public static Contact contactFactory(final Long id,
			final String firstName,
			final String lastName,
			final List<Long> contacInfoIds,
			final List<String> phoneNumbers){
		Contact contact = new Contact();
		contact.setId(id);
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		
	    ContactInfo contactInfo1 = new ContactInfo();
	    contactInfo1.setId(contacInfoIds.get(0));
	    contactInfo1.setPhoneNumber(phoneNumbers.get(0));
		contact.getInfoPhoneNumbers().add(contactInfo1);
	    	
		ContactInfo contactInfo2 = new ContactInfo();
		contactInfo2.setId(contacInfoIds.get(1));
		contactInfo2.setPhoneNumber(phoneNumbers.get(1));
		contact.getInfoPhoneNumbers().add(contactInfo2);
		
		return contact;
		
	}
	
	public static UserContact userContactFactory(final Long id,
			final String firstName,
			final String lastName,
			final List<Long> contacInfoIds,
			final List<String> phoneNumbers){
		UserContact userContact = new UserContact();
		userContact.setFirstName(firstName);
		userContact.setLastName(lastName);
		userContact.setId(id);
		
		UserContactInfo userInfo1 = new UserContactInfo();
		userInfo1.setId(contacInfoIds.get(0));
		userInfo1.setPhoneNumber(phoneNumbers.get(0));
		userContact.getContactInfo().add(userInfo1);
		
		UserContactInfo userInfo2 = new UserContactInfo();
		userInfo2.setId(contacInfoIds.get(1));
		userInfo2.setPhoneNumber(phoneNumbers.get(1));
		userContact.getContactInfo().add(userInfo2);
		
		return userContact;
		
	}
	    
	
}
