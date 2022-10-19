package com.company.xenonstack.LoginRepository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.xenonstack.Logindomain.User;

@Repository
@Transactional
public class LoginRepository{
	
	@Autowired
	EntityManager em;

	public User findUser(User user) {
		User temp = em.find(User.class, user.getUsername());
		if(temp != null && temp.getUsername().equals(user.getUsername()) && temp.getPassword().equals(user.getPassword())) {
			return temp;
		}
		return null;
	}
	
	public void saveUser(User user) {
		em.persist(user);
	}
	
}
