package com.apex.storeintelligence.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import com.apex.storeintelligence.dto.EventRequest;
import com.apex.storeintelligence.entity.Event;
import com.apex.storeintelligence.repository.EventRepository;

@Service
public class EventService {
	
	private final EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
	    this.eventRepository = eventRepository;
	}

	
	public Event saveEvent(EventRequest request) {
	    Event event = new Event();
	    event.setEventId(request.getEventId());
	    event.setStoreId(request.getStoreId());
	    event.setVisitorId(request.getVisitorId());
	    event.setCameraId(request.getCameraId());
	    event.setEventType(request.getEventType());
	    event.setZoneId(request.getZoneId());
	    event.setTimestamp(request.getTimestamp());
	    event.setDwellMs(request.getDwellMs());
	    event.setIsStaff(request.getIsStaff());
	    event.setConfidence(request.getConfidence());
	    
	    return eventRepository.save(event);
	}
	
	public Long getCount(){
		return eventRepository.count();
	}
	
	public Double getAverageDwellTime(){
		return eventRepository.getAverageDwellTime();
	}
	
	public List<Event> findAll(){
		return eventRepository.findAll();
	}
	
	
	public ResponseEntity<Event> findById(String eventId) {
	    return eventRepository.findById(eventId)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}
	
	public Long getUniqueVisitorCount(){
		return eventRepository.getUniqueVisitorCount();
	}
	
	public List<Event> findByVisitorId(String visitorId){
		return eventRepository.findByVisitorId(visitorId);
		
	}
	public Long getStaffCount(){
		return eventRepository.countByIsStaff(true);
	}
	public Long getCustomerCount(){
		return eventRepository.countByIsStaff(false);
	}
	public List<Event> getZoneEvents(String zoneId){
		return eventRepository.findByZoneId(zoneId);
	}
	public List<Object[]> getZoneAnalytics(){
		return eventRepository.getZoneWiseCounts();	
	}
	public List<Object[]> getPeakHours(){
		return eventRepository.getPeakHours();	
	}


}
