package com.nagarro.ProductApi.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nagarro.ProductApi.Dao.UserDao;
import com.nagarro.ProductApi.Entities.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private PasswordEncoder passwordencoder;

	@Autowired
	private UserDao userDao;

	public User register(User user) {
		System.out.println("coming in user");
		User Saveduser = userDao.save(user);
		user.setPassword(passwordencoder.encode(user.getPassword()));
		System.out.println(Saveduser.getPassword());
		return Saveduser;

	}

	public long countUser() {
		return userDao.count();
	}

	public 	User login(User user) {
		
		try{
			User Saveduser = userDao.getReferenceById(user.getEmail());
			System.out.println(Saveduser.getEmail()+Saveduser.getPassword());
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			System.out.println(user.getPassword()+Saveduser.getPassword());
			boolean matches=user.getPassword().equals(Saveduser.getPassword());
//			boolean matches = encoder.matches(user.getPassword(), Saveduser.getPassword());
			
	         System.out.println(matches);
			if (matches) {
				System.out.println(Saveduser.getEmail());
				User fulluser=userDao.findByEmail(user.getEmail());
				System.out.println(fulluser.getFirstName());
				return fulluser;

			} 
		}
		catch(Exception e) {
			return new User();
		}
		
		return new User();

	}

}
