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

import com.meeting.manager.MeetingManager;
import com.meeting.modelView.MeetingView;

@RestController
@RequestMapping(value="/api/meeting")
public class MeetingRestController {
	
	@Autowired
	private MeetingManager meetingManager;
	
	// CREATE NEW MEETING
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeetingView> createMeeting(@RequestBody MeetingView meeting) {
		
		// Implement a CONFLICT response
		
		MeetingView newMeeting = meetingManager.create(meeting);
		return new ResponseEntity<>(newMeeting, HttpStatus.CREATED);
		
	}
	
	// GET MEETING BY ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeetingView> findById(@PathVariable("id") Long id) {
		
		MeetingView meeting = meetingManager.findById(id);
		
		if (meeting == null) {
			
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			
		} else {
			
			return new ResponseEntity<>(meeting, HttpStatus.OK);
			
		}
		
	}
	
	// GET ALL MEETINGS
	@RequestMapping(value="/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeetingView>> findAllMeetings() {
		
		List<MeetingView> allMeetings = meetingManager.getAll();
		return new ResponseEntity<>(allMeetings, HttpStatus.OK);
		
	}
	
	// GET MEETINGS BY HOST ID
	@RequestMapping(
			value="/byHost/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MeetingView>> findByHost(@PathVariable("id") Long id) {
		
		List<MeetingView> hostedMeetings = meetingManager.findByHost(id);
		return new ResponseEntity<>(hostedMeetings, HttpStatus.OK);
		
	}	
	
	// UPDATE MEETING
	@RequestMapping(value="/", method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MeetingView> updateMeeting(@RequestBody MeetingView meeting) {
		
		MeetingView updatedMeeting = meetingManager.update(meeting);
		return new ResponseEntity<>(updatedMeeting, HttpStatus.OK);
			
	}
	
	// DELETE MEETING
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteById(@PathVariable ("id") Long id) {
	
		Boolean meetingDeleted = meetingManager.deleteById(id);
		return new ResponseEntity<>(meetingDeleted, HttpStatus.OK);
	
	}

}
