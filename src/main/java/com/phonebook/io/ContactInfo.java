package com.phonebook.io;

import com.phonebook.model.UserContactInfo;

public class ContactInfo {
   
	private Long id;
	private String phoneNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public static ContactInfo fromUserContactInfoToContactInfo(UserContactInfo userContactInfo){
		ContactInfo contactInfo = new ContactInfo();
		contactInfo.setId(userContactInfo.getId());
		contactInfo.setPhoneNumber(userContactInfo.getPhoneNumber());
		return contactInfo;
	}
}
