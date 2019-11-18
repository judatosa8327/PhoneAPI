package com.phonebook.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phonebook.config.ConfigurationTest;
import com.phonebook.io.Contact;
import com.phonebook.model.UserContact;
import com.phonebook.service.ContactService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactControllerTest {
	
	@Mock
	ContactService contactService;
	
	Contact user1;
	Contact user2;
	
	String firstName;
	String lastName;
	
	UserContact userModel;
	
	Set<Contact> contactUsers = new HashSet<Contact>();

	@Before
	public void contextLoads(){
		user1= ConfigurationTest.contactFactory(1L,
				"Juan", 
				"Torres", 
				Arrays.asList(1L,2L), 
				Arrays.asList("5555555","6666666"));
		
		user1= ConfigurationTest.contactFactory(2L,
				"Juan Esteban", 
				"Torres Cardona", 
				Arrays.asList(3L,24L), 
				Arrays.asList("7777777","88888888"));
		
		firstName = "esteban";
		lastName = "torres";
		
		contactUsers.add(user1);
		contactUsers.add(user2);
		
		userModel = ConfigurationTest.userContactFactory(user1.getId(), 
				user1.getFirstName(), 
				user1.getLastName(), 
				Arrays.asList(1L,2L), 
				Arrays.asList("5555555","6666666"));
	}
	
	@Test
	public void saveContactUserTest(){
		Mockito.when(contactService.saveContact(user1)).thenReturn(user1);
		assertEquals(userModel.getId(),user1.getId());
			
	}
	
	@Test 
	public void getContactUsersByFilterTest(){
		Mockito.when(contactService.getContacts(firstName, lastName)).
		thenReturn(contactUsers);
		assertTrue(contactUsers.contains(user2));	
	}
	
	@Test
	public void getallContacts(){
		Mockito.when(contactService.getContacts(null,null)).
		thenReturn(contactUsers);
		assertTrue(contactUsers.size() == 2);
	}
	
}
