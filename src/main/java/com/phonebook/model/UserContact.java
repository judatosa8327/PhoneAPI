package com.phonebook.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.phonebook.io.Contact;

@Entity(name="user_contact")
public class UserContact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "userContact", cascade = CascadeType.ALL)
	private Set<UserContactInfo> contactInfo = new HashSet<>();

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

	public Set<UserContactInfo> getContactInfo() {
		return contactInfo;
	}
	
	public static UserContact fromRequestContactToUserContact(Contact requestContact){
		UserContact userContact = new UserContact();
		userContact.setFirstName(requestContact.getFirstName());
		userContact.setLastName(requestContact.getLastName());
		requestContact.getInfoPhoneNumbers().forEach(
				extraInfo -> {
					userContact.getContactInfo().add(UserContactInfo.fromContactInfotoUserContactInfo(extraInfo,userContact));
				});
		return userContact;
		
	}

}
