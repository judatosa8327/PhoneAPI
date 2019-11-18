package com.phonebook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.model.UserContact;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact,Long> {
	
	List<UserContact> findAll();	
}
