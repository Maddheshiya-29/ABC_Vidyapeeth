package com.abcvidyapeeth.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abcvidyapeeth.backend.entity.User;
import com.abcvidyapeeth.backend.entity.UserPrincipal;
import com.abcvidyapeeth.backend.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User usr = repo.findByUsername(username);
		if(usr == null) {
			System.out.println("User not found!!");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrincipal(usr);
	}

}
