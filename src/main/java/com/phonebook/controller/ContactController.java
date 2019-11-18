package com.phonebook.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.io.Contact;
import com.phonebook.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/users")
	public ResponseEntity<Set<Contact>> getContacts(
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "lastName", required = false) String lastName){
		return new ResponseEntity<>(contactService.getContacts(firstName, lastName),HttpStatus.OK);
	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Contact> saveContact(@RequestBody(required = true) Contact requestContact){
		return new ResponseEntity<>(contactService.saveContact(requestContact),HttpStatus.CREATED);
	}

}
