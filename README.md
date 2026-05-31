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
/events/ingest
```

Request Body:

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

Response:

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
/events
```

Returns all events stored in the database.

---

### 3. Get Event By ID

**GET**

```http
/events/{eventId}
```

Example:

```http
/events/EVT001
```

---

### 4. Get Total Visitor Count

**GET**

```http
/analytics/visitors/count
```

Returns total number of visitor records.

---

### 5. Get Unique Visitor Count

**GET**

```http
/analytics/visitors/uniqueCount
```

Returns count of distinct visitors.

---

### 6. Get Average Dwell Time

**GET**

```http
/analytics/dwell-time/avg
```

Returns average dwell time in milliseconds.

---

### 7. Get Events By Visitor

**GET**

```http
/visitors/events/{visitorId}
```

Example:

```http
/visitors/events/VIS001
```

Returns all events associated with the visitor.

---

### 8. Get Staff Count

**GET**

```http
/analytics/staff/count
```

Returns count of staff events.

---

### 9. Get Customer Count

**GET**

```http
/analytics/customers/count
```

Returns count of customer events.

---

### 10. Get Events By Zone

**GET**

```http
/zones/{zoneId}/events
```

Example:

```http
/zones/ENTRY/events
```

Returns all events for a specific zone.

---

### 11. Zone Analytics

**GET**

```http
/analytics/zones
```

Returns zone-wise event distribution.

Example Response:

```json
[
  ["ENTRY", 50],
  ["ELECTRONICS", 30],
  ["BILLING", 20]
]
```

---

### 12. Peak Hours Analytics

**GET**

```http
/analytics/peak-hours
```

Returns visitor distribution grouped by hour.

Example Response:

```json
[
  [18, 120],
  [17, 110],
  [19, 95]
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

