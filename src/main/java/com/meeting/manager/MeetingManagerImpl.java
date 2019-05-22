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

import com.meeting.viewmodel.MeetingView;

@Service
public class MeetingManagerImpl implements MeetingManager {

	public static final String REST_SERVICE_URI = "http://localhost:7080/meeting-planner-backend/meeting/";
	
	@Autowired
	private RestTemplate rest;
	
	@Override
	public MeetingView create(MeetingView meeting) {

		return rest.postForObject(REST_SERVICE_URI, meeting, MeetingView.class);
		
	}

	@Override
	public MeetingView update(MeetingView meeting) {

		ResponseEntity<MeetingView> response = rest.exchange(
				REST_SERVICE_URI,
				HttpMethod.PUT,
				new HttpEntity<>(null, new HttpHeaders()),
				MeetingView.class);
		
		return response.getBody();
		
	}

	@Override
	public MeetingView findById(Long id) {
		
		MeetingView meeting = rest.getForObject(REST_SERVICE_URI + id, MeetingView.class);
		return meeting;
		
	}

	@Override
	public boolean deleteById(Long id) {
		
		ResponseEntity<Boolean> response = rest.exchange(
				REST_SERVICE_URI + id,
				HttpMethod.DELETE,
				new HttpEntity<>(null, new HttpHeaders()),
				Boolean.class);

		return response.getBody();
		
	}

	@Override
	public List<MeetingView> findByHost(Long id) {

		ResponseEntity<List<MeetingView>> response = rest.exchange(
				REST_SERVICE_URI + "/byHost/" + id,
				HttpMethod.GET,
				new HttpEntity<>(null, new HttpHeaders()),
				new ParameterizedTypeReference<List<MeetingView>>() {});
		
		return response.getBody();
		
	}

	@Override
	public List<MeetingView> getAll() {
		
		ResponseEntity<List<MeetingView>> response = rest.exchange(
				REST_SERVICE_URI,
				HttpMethod.GET,
				new HttpEntity<>(null, new HttpHeaders()),
				new ParameterizedTypeReference<List<MeetingView>>() {});
		
		return response.getBody();
		
	}
	
}
