package com.apex.storeintelligence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.apex.storeintelligence.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {
	
	@Query("SELECT AVG(e.dwellMs) FROM Event e")
	Double getAverageDwellTime();
	
	@Query("SELECT COUNT(DISTINCT e.visitorId) FROM Event e")
	Long getUniqueVisitorCount();
	
	List<Event> findByVisitorId(String visitorId);
	
	Long countByIsStaff(Boolean isStaff);
	
	List<Event> findByZoneId(String zoneId);
	
	@Query("""
		       SELECT e.zoneId, COUNT(e)
		       FROM Event e
		       GROUP BY e.zoneId
		       """)
		List<Object[]> getZoneWiseCounts();
		
		@Query("""
			       SELECT HOUR(e.timestamp), COUNT(e)
			       FROM Event e
			       GROUP BY HOUR(e.timestamp)
			       ORDER BY COUNT(e) DESC
			       """)
			List<Object[]> getPeakHours();
}