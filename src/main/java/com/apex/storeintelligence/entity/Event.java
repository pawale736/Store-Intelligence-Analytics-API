package com.apex.storeintelligence.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="events")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    private String eventId;
    private String storeId;
    private String visitorId;
    private String cameraId;
    private String eventType;
    private String zoneId;
    private LocalDateTime timestamp;
    private Long dwellMs;
    private Boolean isStaff;
    private Double confidence;
}
