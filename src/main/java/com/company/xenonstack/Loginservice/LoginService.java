package com.company.xenonstack.Loginservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.xenonstack.LoginRepository.LoginRepository;
import com.company.xenonstack.Logindomain.User;



@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
  
  public User login(User user) {
	  return repo.findUser(user);
  }
  
  public void save(User user) {
	  repo.saveUser(user);
  }
	

}