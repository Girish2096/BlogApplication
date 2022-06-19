package com.girish.BlogApplication.Service;

import com.girish.BlogApplication.Entity.User;

public interface UserServiceI {
	
	public User saveUser(User user);
	
	public User updateUser(User user,Integer userid);
	
	public User getuser(Integer userid);

}
