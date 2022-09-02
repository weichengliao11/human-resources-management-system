package com.b06704094.webprogramming.finalproject.b06704094d1.service;

import com.b06704094.webprogramming.finalproject.b06704094d1.entity.User;
import com.b06704094.webprogramming.finalproject.b06704094d1.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	UserEntityRepository userEntityRepository;

	public boolean isCorrected(String userName, String password) {

		User user = userEntityRepository.findByUserName(userName);

		if(user == null)
			return false;

		if(!user.getPassword().equals(password))
			return false;
		return true;
	}

	public void register(User user) {

		User newUser = new User();
		newUser.setUserName(user.getUserName());
		newUser.setPassword(user.getPassword());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		if(user.getEmail() != null)
			newUser.setEmail(user.getEmail());

		userEntityRepository.save(newUser);
	}

	public boolean userNameDuplicated(String userName) {

		return userEntityRepository.existsByUserName(userName);
	}

	public boolean emailDuplicated(String email) {

		return userEntityRepository.existsByEmail(email);
	}
}
