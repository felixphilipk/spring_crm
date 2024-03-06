# CRM Project README

## Overview
This CRM (Customer Relationship Management) project is designed to manage clients and their contact information. It provides a RESTful API for adding clients, adding contact information to clients, and querying clients and their contacts. The project uses Spring Boot for the backend, JPA (Java Persistence API) for ORM (Object-Relational Mapping), and PostgreSQL as the database.

## Pre-requisites
- Java JDK 11 or higher
- Maven 3.6 or higher
- PostgreSQL database

## Database Setup
1. Install PostgreSQL and create a new database named `crm`.
2. Update the `src/main/resources/application.properties` file with your PostgreSQL settings:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/crm
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    ```
3. Ensure the PostgreSQL server is running.

## Project Setup
1. Clone the repository and navigate to the project directory.
2. Run `mvn install` to install the necessary dependencies.
3. Start the application by running `mvn spring-boot:run` or by executing the main method in `CrmApplication.java` using your IDE.

## API Endpoints
You can use Postman or any other API testing tool to call the following endpoints:

### Add a New Client
- **Endpoint:** `POST /api/clients/`
- **Body:** 
    ```json
    {
        "name": "Test"
    }
    ```
- **Description:** Adds a new client with the provided name.

### Add a New Client Contact
- **Endpoint:** `POST /api/clients/{clientId}/contacts`
- **Path Variable:** `clientId` - the ID of the client
- **Body:** 
    ```json
    {
        "value": "email@example.com",
        "type": "email"
    }
    ```
- **Description:** Adds a new contact (phone or email) to the specified client.

### Get All Clients
- **Endpoint:** `GET /api/clients/`
- **Description:** Retrieves a list of all clients.

### Get Client by ID
- **Endpoint:** `GET /api/clients/{id}`
- **Path Variable:** `id` - the ID of the client
- **Description:** Retrieves details of a specific client by ID.

### Get Contacts for a Client
- **Endpoint:** `GET /api/clients/{clientId}/contacts`
- **Path Variable:** `clientId` - the ID of the client
- **Description:** Retrieves all contacts associated with the specified client.

### Get Contacts of a Specific Type for a Client
- **Endpoint:** `GET /api/clients/{clientId}/contacts/{type}`
- **Path Variables:** 
    - `clientId` - the ID of the client
    - `type` - the type of contact (e.g., "email" or "phone")
- **Description:** Retrieves contacts of a specific type for the specified client.

## Calling Endpoints with Postman
1. Open Postman and create a new request.
2. Set the HTTP method to match the endpoint's method (e.g., `GET`, `POST`).
3. Enter the full URL of the endpoint.
4. For `POST` requests, set the body type to `raw` and format to `JSON`, then enter the request body.
5. Send the request and view the response.

