# OneNest – Smart Hostel & Mess Management System

OneNest is a hostel and mess management platform designed to simplify daily mess operations, improve meal planning, and reduce food wastage through student meal attendance tracking.

The platform aims to connect students, mess incharges, and hostel administrators through a centralized system.

## Overview

Managing hostel mess operations manually can lead to inaccurate meal counts, food wastage, and difficulties in coordinating daily activities.

OneNest aims to address these challenges by providing a digital platform where students can confirm their meal attendance and mess incharges can manage daily menus and monitor meal requirements.

## Key Features

### Implemented

- **Student Registration:** Register students with essential hostel and personal details.
- **Student Login:** Authenticate students using email and password.
- **Password Security:** Secure password storage using BCrypt hashing.
- **JWT Authentication:** Generate and validate JSON Web Tokens for authenticated requests.
- **Input Validation:** Validate incoming registration and login requests.
- **Exception Handling:** Handle duplicate records and invalid login credentials.
- **MySQL Integration:** Persist student information in a relational database.

### Planned

- Daily meal attendance tracking.
- Breakfast, lunch, and dinner menu management.
- Mess incharge dashboard.
- Hostel administrator dashboard.
- Meal count and food requirement estimation.
- Reports and analytics for reducing food wastage.
- Frontend integration with backend REST APIs.

## Technology Stack

| Category | Technologies |
|---|---|
| Backend | Java, Spring Boot |
| Backend Architecture | REST APIs, Layered Architecture |
| Security | Spring Security, JWT, BCrypt |
| Database | MySQL |
| ORM | Spring Data JPA, Hibernate |
| Build Tool | Maven |
| API Testing | Postman |
| IDE | IntelliJ IDEA |
| Version Control | Git and GitHub |

## Project Structure

```text
OneNest/
│
├── backend/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/onenest/backend/
│   │   │   │   ├── config/
│   │   │   │   ├── controller/
│   │   │   │   ├── dto/
│   │   │   │   ├── entity/
│   │   │   │   ├── exception/
│   │   │   │   ├── filter/
│   │   │   │   ├── repository/
│   │   │   │   ├── service/
│   │   │   │   └── BackendApplication.java
│   │   │   │
│   │   │   └── resources/
│   │   │       └── application.properties
│   │   │
│   │   └── test/
│   ├── pom.xml
│   └── mvnw
│
├── postman/
│
├── .gitignore
└── README.md
```

## Getting Started

### Prerequisites

Make sure you have installed:

- Java JDK 22
- IntelliJ IDEA or another Java IDE
- MySQL Server and MySQL Workbench
- Git

Maven Wrapper is included in the backend directory, so a separate Maven installation is not required to run the project.

### 1. Clone the Repository

```bash
git clone https://github.com/Rajababu0301/OneNest.git
```

### 2. Navigate to the Backend

```bash
cd OneNest/backend
```

### 3. Create the MySQL Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE onenest_db;
```

### 4. Configure Environment Variables

The backend uses environment variables for database credentials and JWT configuration.

Configure these variables before starting the application:

| Variable | Description |
|---|---|
| `DB_USERNAME` | MySQL username |
| `DB_PASSWORD` | MySQL password |
| `JWT_SECRET` | Strong secret key for JWT signing |

For Windows PowerShell, you can configure them for the current terminal session:

```powershell
$env:DB_USERNAME="your_mysql_username"
$env:DB_PASSWORD="your_mysql_password"
$env:JWT_SECRET="your_generated_secret"
```

Use your own credentials. Never commit actual passwords or JWT secrets to GitHub.

### 5. Run the Application

From the `backend` directory, execute:

```powershell
.\mvnw.cmd spring-boot:run
```

Alternatively, open the project in IntelliJ IDEA and run the `BackendApplication` main class after configuring the required environment variables.

The backend runs on:

```text
http://localhost:8080
```

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description | Authentication |
|---|---|---|---|
| POST | `/api/students/register` | Register a student | Not required |
| POST | `/api/students/login` | Authenticate a student | Not required |
| GET | `/api/students/profile` | Access protected student endpoint | JWT required |

### Authentication

After successful login, the API returns a JWT.

For protected endpoints, include the token in the request header:

```http
Authorization: Bearer YOUR_JWT_TOKEN
```

## Testing

The backend APIs can be tested using Postman.

The project includes API-related resources in the `postman/` directory and an HTTP request file at `backend/student-api.http`.

Recommended testing sequence:

1. Register a student.
2. Verify the student record in MySQL.
3. Log in using the registered credentials.
4. Copy the JWT returned by the login API.
5. Access the protected profile endpoint using the Bearer token.
6. Test invalid credentials and duplicate registration scenarios.

## Security Practices

- Passwords are hashed using BCrypt.
- JWT secrets are supplied through environment variables.
- Database credentials are not intended to be committed to the repository.
- Protected API requests use JWT-based authentication.
- Git ignore rules exclude local configuration and sensitive files.

## Current Development Status

**Backend Development:** Initial implementation completed.

**Frontend Development:** Planned / in progress.

**Additional Hostel and Mess Modules:** Planned.

OneNest is being developed incrementally, with the aim of building a complete hostel and mess management solution.

## Future Scope

- Student dashboard with meal attendance.
- Dynamic daily menu updates.
- Mess incharge management panel.
- Hostel administration features.
- Automated meal requirement estimation.
- Food wastage monitoring and analytics.
- Responsive web interface.

## Contribution

This project is currently under active development. Suggestions, feedback, and contributions are welcome.

## Author

**OneNest Project**

GitHub Repository: https://github.com/Rajababu0301/OneNest

---

*OneNest – Simplifying Hostel Living, One Meal at a Time.*