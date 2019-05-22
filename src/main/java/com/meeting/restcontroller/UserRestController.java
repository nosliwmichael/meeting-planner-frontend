package com.meeting.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.manager.UserManager;
import com.meeting.viewmodel.UserView;

@RestController
@RequestMapping(value="/api/user")
public class UserRestController {
	
	@Autowired
	private UserManager userManager;
	
	// GET USER BY ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserView> findById(@PathVariable("id") Long id) {
		
		UserView user = userManager.findById(id);

		if (user == null) {
			
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			
		} else {
			
			return new ResponseEntity<>(user, HttpStatus.OK);
			
		}
		
	}
	
	// GET ALL USERS
	@RequestMapping(value="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserView>> getAll() {
		
		List<UserView> allUsers = userManager.getAll();
		
		if (allUsers.isEmpty()) {
			
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			
		} else {
			
			return new ResponseEntity<>(allUsers, HttpStatus.OK);
		
		}
		
	}
	
	// UPDATE USER
	@RequestMapping(value="/", method=RequestMethod.PUT)
	public ResponseEntity<UserView> update(@RequestBody UserView user) {
		
		UserView updatedUser = userManager.update(user);
		
		if (updatedUser == null) {
			
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			
		} else {
			
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		
		}
			
	}
	
}
