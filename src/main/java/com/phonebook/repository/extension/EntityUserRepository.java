package com.phonebook.repository.extension;

import com.phonebook.model.UserContact;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

@Component
public class EntityUserRepository {

  @PersistenceContext 
  private EntityManager entityManager;	 
  
  @SuppressWarnings("unchecked")
public List<UserContact> findUsersByDynamicSearch(final String firstName,
		final String lastName){
	  StringBuilder query = new StringBuilder("select u.* from user_contact u "
	  		+ "where ");
	  Query sqlQuery = null;
	  
	  if(firstName != null && lastName != null) {
		  query.append("u.first_name like :firstName and "); 
		  query.append("u.last_name like :lastName");
		  sqlQuery = entityManager.createNativeQuery(query.toString(),UserContact.class);
		  sqlQuery.setParameter("firstName","%"+firstName+"%");
		  sqlQuery.setParameter("lastName","%"+lastName+"%");
	  }
	  
	  if(firstName != null && lastName == null) {
		  query.append("u.first_name like :firstName");  
		  sqlQuery = entityManager.createNativeQuery(query.toString(),UserContact.class);
		  sqlQuery.setParameter("firstName","%"+firstName+"%");
	  }
	  
	  if(firstName == null && lastName != null) {
		  query.append("u.last_name like :lastName");  
		  sqlQuery = entityManager.createNativeQuery(query.toString(),UserContact.class);
		  sqlQuery.setParameter("lastName","%"+lastName+"%");
	  }
	  
	  return sqlQuery.getResultList();
	  
  }
}
