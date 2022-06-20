package com.girish.BlogApplication.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.girish.BlogApplication.Entity.User;
import com.girish.BlogApplication.Exception.ResourceNotFoundException;
import com.girish.BlogApplication.Repository.UserRepository;

@Service
public class UserServiceImp implements UserServiceI {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User saveUser(User user) {
		User save = userRepo.save(user);
		return save;
	}

	@Override
	public User updateUser(User user, Integer userid) {
		User user1 = userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("user","id",userid));
		user1.setUsername(user.getUsername());
		user1.setEmail(user.getEmail());
		user1.setPassword(user.getPassword());
		user1.setAbout(user.getAbout());
		return user1;
	}

	@Override
	public User getuser(Integer userid) {
		
		 User user = userRepo.findById(userid).get();
		 return user;
	}
	
	
	public List<User> getall()	{
		List<User> findAll = userRepo.findAll();
		return findAll;
		
	}
	
	
	public void deleteid(Integer userid)
	{
		userRepo.deleteById(userid);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
