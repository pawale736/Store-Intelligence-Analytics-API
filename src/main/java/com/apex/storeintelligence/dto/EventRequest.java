package com.apex.storeintelligence.dto;
import lombok.Data;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

@Data
public class EventRequest {
    @NotBlank
	private String eventId;
    private String storeId;
    @NotBlank
    private String visitorId;
    private String cameraId;
    private String eventType;
    private String zoneId;
    private LocalDateTime timestamp;
    private Long dwellMs;
    private Boolean isStaff;
    private Double confidence;
}