package com.phonebook.io;

import java.util.HashSet;
import java.util.Set;

import com.phonebook.model.UserContact;

public class Contact {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Set<ContactInfo> infoPhoneNumbers = 
			new HashSet<ContactInfo>();
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Set<ContactInfo> getInfoPhoneNumbers() {
		return infoPhoneNumbers;
	}
	
	

	public void setInfoPhoneNumbers(Set<ContactInfo> infoPhoneNumbers) {
		this.infoPhoneNumbers = infoPhoneNumbers;
	}


	public static Contact fromUserContactToContact(UserContact userContact){
		Contact contact = new Contact();
		contact.setId(userContact.getId());
		contact.setFirstName(userContact.getFirstName());
		contact.setLastName(userContact.getLastName());
		contact.getInfoPhoneNumbers().clear();
		userContact.getContactInfo().forEach(
				extraInfo -> {
					contact.getInfoPhoneNumbers().add(ContactInfo.fromUserContactInfoToContactInfo(extraInfo));
				});
		return contact;
	}

}
