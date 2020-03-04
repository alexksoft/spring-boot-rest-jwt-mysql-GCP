package com.ak.eventapi.security.jwt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ak.eventapi.db.domain.UserEntity;
import com.ak.eventapi.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userService.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found with username: " + username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
        
		user.getUserRoles().forEach(role -> {
            	authorities.add(new SimpleGrantedAuthority(role.getAppRole().getRoleName()));
        	}
		);
		
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
	}
}
