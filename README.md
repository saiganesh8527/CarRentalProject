# Car Rental Project (Backend API)

A robust backend REST API application for a Car Rental System built using Java and Spring Boot. This application handles user management, car inventory control, and booking processing, delivering data via secure JSON endpoints.

## 🛠️ Tech Stack
* *Language:* Java (JDK 17 or higher)
* *Framework:* Spring Boot, Spring Data JPA, Spring Security
* *ORM:* Hibernate
* *Database:* MySQL
* *Build Tool:* Maven

## 🚀 Features
* *User Management:* REST endpoints for registration and authentication.
* *Car Inventory API:* CRUD operations to manage available vehicles.
* *Booking System:* Logic to handle real-time reservations and check availability.

## 💻 Getting Started

### 1. Database Setup
Create a database named car_rental_db in MySQL and configure your application.properties:
properties
spring.datasource.url=jdbc:mysql://localhost:3306/car_rental_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update


### 2. Run the Application
bash
git clone https://github.com
cd CarRentalProject
./mvnw spring-boot:run

The server will start at http://localhost:8080.

## 🧪 Testing with Postman & JSON Examples

Set your request header to Content-Type: application/json in Postman before sending requests.

### 1. Authentication Endpoints

#### 👤 User Registration
* *HTTP Method:* POST
* *URL:* http://localhost:8080/api/auth/signup
* *JSON Body:*
json
{
  "username": "saiganesh",
  "email": "sai@example.com",
  "password": "securePassword123"
}


#### 🔑 User Login
* *HTTP Method:* POST
* *URL:* http://localhost:8080/api/auth/login
* *JSON Body:*
json
{
  "username": "saiganesh",
  "password": "securePassword123"
}


---

### 2. Car Management Endpoints

#### 🚗 Add a New Car (Admin Only)
* *HTTP Method:* POST
* *URL:* http://localhost:8080/api/cars
* *JSON Body:*
json
{
  "brand": "Toyota",
  "model": "Fortuner",
  "pricePerDay": 2500.0,
  "available": true
}


#### 📋 Get All Available Cars
* *HTTP Method:* GET
* *URL:* http://localhost:8080/api/cars/available

---

### 3. Booking Endpoints

#### 📅 Create a Booking
* *HTTP Method:* POST
* *URL:* http://localhost:8080/api/bookings
* *JSON Body:*
json
{
  "userId": 1,
  "carId": 2,
  "startDate": "2026-10-10",
  "endDate": "2026-10-15"
}
