NewWorld Backend Project

A Spring Boot backend application inspired by online marketplace platforms such as OLX. The project provides APIs for user management, item listings, authentication, password recovery, and seller verification.

## Features

### User Management

* User Registration
* Login using Email
* Login using Phone Number
* Duplicate Email Validation
* Duplicate Phone Number Validation

### Seller Verification

* Seller Age Verification (18+ required)
* Role-based user registration (Buyer / Seller)

### Password Recovery

* Forgot Password API
* OTP Generation
* OTP Storage in Database
* OTP Verification
* Password Reset Flow (In Progress)

### Item Management

* Add Item
* Get All Items
* Get Item By ID
* Get Items By Category
* Update Item
* Delete Item

### Validation & Exception Handling

* Bean Validation using Jakarta Validation
* Global Exception Handling using `@ControllerAdvice`
* Custom Exceptions

## Tech Stack

* Java 21
* Spring Boot 3
* Spring Web
* Spring Data JPA
* H2 Database
* Maven
* Postman

## Project Structure

```text
src/main/java/com/example/NewWorld
│
├── controller
│   ├── ItemListsController
│   └── UserAuthorizeController
│
├── service
│   ├── ItemService
│   └── UserService
│
├── repository
│   ├── ItemRepository
│   └── UserRepository
│
├── entity
│   ├── Items
│   ├── User
│   ├── Category
│   └── Role
│
├── dto
│   ├── AgeVerificationRequest
│   ├── UserLoginRequest
│   ├── ForgotPasswordRequest
│   └── VerifyOtpRequest
│
└── Exception
    ├── GlobalExceptionHandler
    ├── ItemNotFoundException
    ├── InvalidPriceException
    └── AgeVerificationException
```

## API Endpoints

### User Registration

```http
POST /UserAuthorize/api/register/user
```

### Seller Age Verification

```http
POST /UserAuthorize/api/verify/seller-age
```

### User Login

```http
POST /UserAuthorize/api/userLogin
```

### Forgot Password

```http
POST /UserAuthorize/api/forgot-password
```

### Verify OTP

```http
POST /UserAuthorize/api/verify-reset-otp
```

### Get All Items

```http
GET /api/public/items
```

### Get Item By ID

```http
GET /api/public/items/{id}
```

### Get Items By Category

```http
GET /api/public/items/category/{category}
```

## Running the Project

### Clone Repository

```bash
git clone <repository-url>
```

### Build Project

```bash
mvn clean install
```

### Run Application

```bash
mvn spring-boot:run
```

Application will start at:

```text
http://localhost:8080
```

### H2 Database Console

```text
http://localhost:8080/h2-console
```

Default Configuration:

```text
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password:
```

## Learning Objectives

This project was built to gain hands-on experience with:

* Spring Boot
* REST APIs
* Layered Architecture
* DTO Design
* Validation
* Exception Handling
* JPA/Hibernate
* Repository Pattern
* Authentication Flows
* OTP-Based Password Recovery

## Future Enhancements

* Password Encryption using BCrypt
* JWT Authentication
* Email OTP Integration
* Phone OTP Integration
* Kafka Event Notifications
* Role-Based Authorization
* MySQL/PostgreSQL Integration
* Docker Support
* Unit & Integration Testing

## Author

**Saumoditya Bhattacharya**

Backend Developer | Java | Spring Boot | SQL | Power Platform
