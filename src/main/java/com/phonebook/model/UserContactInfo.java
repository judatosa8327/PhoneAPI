package com.phonebook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.phonebook.io.ContactInfo;

@Entity(name = "user_contact_info")
public class UserContactInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user_contact", referencedColumnName = "id")
	private UserContact userContact;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserContact getUserContact() {
		return userContact;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static UserContactInfo fromContactInfotoUserContactInfo(ContactInfo requestContactInfo,
			UserContact userContact){
		UserContactInfo userContactInfo = new UserContactInfo();
		userContactInfo.setPhoneNumber(requestContactInfo.getPhoneNumber());
		userContactInfo.setUserContact(userContact);
		return userContactInfo;
	}

}
