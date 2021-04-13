package com.jwtdemo.service;

import com.jwtdemo.config.CustomException;
import com.jwtdemo.config.UserPrincipal;
import com.jwtdemo.model.UserDao;
import com.jwtdemo.model.UserDto;
import com.jwtdemo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@Transactional
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
        UserPrincipal userPrincipal = new UserPrincipal(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				userPrincipal.getAuthorities());
	}
	public UserDao save(@Valid UserDto user) throws CustomException {
			UserDao newUser = new UserDao();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setRole_id(user.getRole_id());
			newUser.setActive(1);
			return userDao.save(newUser);
	}
}