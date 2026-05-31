package com.apex.storeintelligence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apex.storeintelligence.dto.EventRequest;
import com.apex.storeintelligence.entity.Event;
import com.apex.storeintelligence.service.EventService;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/events/ingest")
	public ResponseEntity<Event> ingest(@RequestBody EventRequest request) {
	    return ResponseEntity.ok(eventService.saveEvent(request));
	}
	
	@GetMapping("/analytics/visitors/count")
	public ResponseEntity<Long> getVisitorCount() {
	    return ResponseEntity.ok(eventService.getCount());
	}
	
	@GetMapping("/analytics/dwell-time/avg")
	public ResponseEntity<Double> getAverageDwellTime() {
	    return ResponseEntity.ok(eventService.getAverageDwellTime());
	}
	
	@GetMapping("/events")
	public ResponseEntity<List<Event>> getAllEvents() {
	    return ResponseEntity.ok(eventService.findAll());
	}
	
	@GetMapping("/events/{eventId}")
	public ResponseEntity<Event> getEvent(@PathVariable String eventId) {
	    return eventService.findById(eventId);
	}
	
	@GetMapping("/analytics/visitors/uniqueCount")
	public ResponseEntity<Long> getUniqueVisitorCount() {
	    return ResponseEntity.ok(eventService.getUniqueVisitorCount());
	}
	
	@GetMapping("/visitors/events/{visitorId}")
	public ResponseEntity<List<Event>> getVisitorEvents(@PathVariable String visitorId) {
	    return ResponseEntity.ok(eventService.findByVisitorId(visitorId));
	}
	
	@GetMapping("/analytics/staff/count")
	public ResponseEntity<Long> getStaffCount() {
	    return ResponseEntity.ok(eventService.getStaffCount());
	}
	
	@GetMapping("/analytics/customers/count")
	public ResponseEntity<Long> getCustomerCount() {
	    return ResponseEntity.ok(eventService.getCustomerCount());
	}
	
	@GetMapping("/zones/{zoneId}/events")
	public ResponseEntity<List<Event>> getZoneEvents(@PathVariable String zoneId) {
	    return ResponseEntity.ok(eventService.getZoneEvents(zoneId));
	}
	
	@GetMapping("/analytics/zones")
	public ResponseEntity<List<Object[]>> getZoneAnalytics() {
	    return ResponseEntity.ok(eventService.getZoneAnalytics());
	}
	
	@GetMapping("/analytics/peak-hours")
	public ResponseEntity<List<Object[]>> getPeakHours() {
	    return ResponseEntity.ok(eventService.getPeakHours());
	}

}
