package com.meeting.manager;

import java.util.List;

import com.meeting.modelView.LoginView;
import com.meeting.modelView.UserView;

public interface UserManager {
	
	public boolean loginUser(LoginView login);
	
	public UserView create(UserView user);
	
	public UserView update(UserView user);
	
	public UserView findById(Long id);
	
	public List<UserView> getAll();
	
}
