package com.meeting.manager;

import java.util.List;

import com.meeting.viewmodel.MeetingView;

public interface MeetingManager {
	
	public MeetingView create(MeetingView meeting);
	
	public MeetingView update(MeetingView meeting);
	
	public MeetingView findById(Long id);
	
	public boolean deleteById(Long id);
	
	public List<MeetingView> findByHost(Long id);
	
	public List<MeetingView> getAll();
	
}
