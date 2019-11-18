package com.phonebook.service.serviceImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.io.Contact;
import com.phonebook.model.UserContact;
import com.phonebook.repository.UserContactRepository;
import com.phonebook.repository.extension.EntityUserRepository;
import com.phonebook.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {
	
	Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Autowired
	private UserContactRepository userContactRepository;
	
	@Autowired
	private EntityUserRepository repository;

	@Override
	public Set<Contact> getContacts(final String firstName, 
			final String lastName) {
		logger.info("Executing general search");
		if(firstName == null && lastName == null) {
			return parseToContact(userContactRepository.
					findAll().
					stream().
					collect(Collectors.toSet()));	
		}else{
			return parseToContact(repository.
					findUsersByDynamicSearch(firstName, lastName).
					stream().
					collect(Collectors.toSet()));	
		}
		
	}
	
	private Set<Contact> parseToContact(final Set<UserContact> userContacts){
		Set<Contact> contacts = new HashSet<Contact>();
		contacts.clear();
		userContacts.forEach(userContact -> {
			contacts.add(Contact.fromUserContactToContact(userContact));
		});
		return contacts;
		
	}

	@Override
	public Set<UserContact> getContacts(Contact requestContact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact saveContact(final Contact requestContact) {
		logger.info("Saving new contact");
		UserContact userContact = UserContact.fromRequestContactToUserContact(requestContact);
		userContactRepository.save(userContact);
		return parseToContact(userContact);
	}
	
	private Contact parseToContact(UserContact userContact){
		return Contact.fromUserContactToContact(userContact);
	}
	

	
}
