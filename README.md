# Store Intelligence Analytics API

## Overview

Store Intelligence Analytics API is a Spring Boot backend application that ingests retail store events and provides analytics such as visitor count, dwell time, peak hours, zone-wise traffic, and store-specific insights.

The application uses Spring Boot, Spring Data JPA, Hibernate, and MySQL.


## Tech Stack

* Java 21
* Spring Boot 3.x
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Lombok
* Postman


## Project Structure

src/main/java
│
├── controller
│   └── EventController
│
├── service
│   └── EventService
│
├── repository
│   └── EventRepository
│
├── entity
│   └── Event
│
└── dto
    └── EventRequest


## Database Configuration

application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/store_intelligence
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Event Entity

```java
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
```

---

## API Endpoints

### 1. Ingest Event

**POST**

```http
/api/events/ingest
```

Request:

```json
{
  "eventId": "EVT001",
  "storeId": "ST1008",
  "visitorId": "VIS001",
  "cameraId": "CAM1",
  "eventType": "ENTRY",
  "zoneId": "ENTRY",
  "timestamp": "2026-04-10T10:15:22",
  "dwellMs": 0,
  "isStaff": false,
  "confidence": 0.95
}
```

---

### 2. Get All Events

**GET**

```http
/api/events
```

---

### 3. Get Event By ID

**GET**

```http
/api/events/{eventId}
```

Example:

```http
/api/events/EVT001
```

---

### 4. Total Event Count

**GET**

```http
/api/analytics/events/count
```

---

### 5. Unique Visitor Count

**GET**

```http
/api/analytics/visitors/count
```

---

### 6. Average Dwell Time

**GET**

```http
/api/analytics/dwell-time/avg
```

Returns average visitor dwell time in milliseconds.

---

### 7. Events By Store

**GET**

```http
/api/stores/{storeId}/events
```

Example:

```http
/api/stores/ST1008/events
```

---

### 8. Events By Visitor

**GET**

```http
/api/visitors/{visitorId}/events
```

Example:

```http
/api/visitors/VIS001/events
```

---

### 9. Staff Count

**GET**

```http
/api/analytics/staff/count
```

---

### 10. Customer Count

**GET**

```http
/api/analytics/customers/count
```

---

### 11. Zone Analytics

**GET**

```http
/api/analytics/zones
```

Returns zone-wise visitor counts.

Example Response:

```json
[
  ["ENTRY", 50],
  ["ELECTRONICS", 20],
  ["BILLING", 15]
]
```

---

### 12. Peak Hours Analytics

**GET**

```http
/api/analytics/peak-hours
```

Example Response:

```json
[
  [18,120],
  [17,110],
  [19,95]
]
```

---

## Running the Application

Clone repository:

```bash
git clone <repository-url>
```

Move to project directory:

```bash
cd store-intelligence-api
```

Build application:

```bash
mvn clean install
```

Run application:

```bash
mvn spring-boot:run
```

Application starts at:

```text
http://localhost:8080
```

---

## Testing

Use Postman to test:

* Event Ingestion API
* Visitor Analytics
* Dwell Time Analytics
* Zone Analytics
* Peak Hours Analytics

---

## Future Enhancements

* Docker Support
* Authentication & Authorization
* Pagination and Sorting
* Date Range Analytics
* Unit Testing with JUnit and Mockito
* Dashboard Integration

---

## Author

Dayanand Pawale

Backend Developer | Java | Spring Boot | MySQL

