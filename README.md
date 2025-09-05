# Traveller REST API

A Spring Boot RESTful API for managing traveller information, including locations, visited countries, and travel plans. Supports MySQL database with full CRUD operations.

---

## Technologies Used

* Java 17
* Spring Boot 3.5.5
* Spring Data JPA
* MySQL (Workbench GUI)
* Springdoc OpenAPI / Swagger UI

---

## Features

* Create, Read, Update, Delete traveller records
* Manage `visitedCountries` for each traveller (`@ElementCollection`)
* Partial updates with PATCH
* Optimistic locking with `@Version`
* API documentation via Swagger UI

---

## Installation / Running the Project

1. **Clone the repository**

```bash
git clone <[(https://github.com/Vinod-0315/Traveller-Management-System.git)]
cd <project-folder>
```

2. **Configure database**

* Update `application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/travellerdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the project**

* Using Maven:

```bash
mvn spring-boot:run
```

* Or from your IDE (Eclipse / IntelliJ): run the main class `RestApiApplication.java`

---

## API Documentation

After running the application, access Swagger UI at:

```
http://localhost:8080/swagger-ui.html
```

* API endpoints are self-documented with request/response details.

---

## Example Endpoints

| Method | Endpoint           | Description                 |
| ------ | ------------------ | --------------------------- |
| GET    | `/travellers`      | Get all travellers          |
| GET    | `/travellers/{id}` | Get traveller by ID         |
| POST   | `/travellers`      | Add new traveller           |
| PATCH  | `/travellers/{id}` | Partial update of traveller |
| DELETE | `/travellers/{id}` | Delete traveller by ID      |

---

## Notes

* Deleting a traveller automatically deletes the associated `visitedCountries` entries (`@ElementCollection`)
* Partial updates using `PATCH` increment `@Version` for optimistic locking

---

## Author

Vinod Lucky
