package com.meeting.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.meeting.viewmodel.LoginView;
import com.meeting.viewmodel.UserView;

@Service
public class UserManagerImpl implements UserManager {

	public static final String REST_SERVICE_URI = "http://localhost:7080/meeting-planner-backend/user/";

	@Autowired
	private RestTemplate rest;
	
	@Override
	public boolean loginUser(LoginView login) {
		return true;
	}

	@Override
	public UserView create(UserView user) {
		
		return rest.postForObject(REST_SERVICE_URI, user, UserView.class);
		
	}

	@Override
	public UserView update(UserView user) {
		
		ResponseEntity<UserView> response = rest.exchange(
				REST_SERVICE_URI,
				HttpMethod.PUT,
				new HttpEntity<>(null, new HttpHeaders()),
				UserView.class);
		
		return response.getBody();
		
	}

	@Override
	public UserView findById(Long id) {
		
		return rest.getForObject(REST_SERVICE_URI + id, UserView.class);
		
	}

	@Override
	public List<UserView> getAll() {
		
		ResponseEntity<List<UserView>> response = rest.exchange(
				REST_SERVICE_URI,
				HttpMethod.GET,
				new HttpEntity<>(null, new HttpHeaders()),
				new ParameterizedTypeReference<List<UserView>>() {});
		
		return response.getBody();
		
	}
	
}
