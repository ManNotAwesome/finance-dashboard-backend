# Finance Dashboard Backend

## Project Overview

Finance Dashboard Backend is a backend application built using Spring Boot and MySQL to manage financial records, user roles, access control, and dashboard analytics.

The project demonstrates backend architecture, CRUD operations, filtering, summary calculations, role-based restrictions, validation, and exception handling.

---

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Spring Security
* Maven

---

## Features Implemented

* User and Role Management (create users, assign roles, update active/inactive status)
* Financial Records CRUD Operations
* Record Filtering (by category and type)
* Dashboard Summary APIs (total income, total expense, net balance, category totals)
* Basic Role Based Access Control using request headers
* Exception Handling for invalid resources
* Data Persistence using MySQL

---

## Project Structure

src/main/java

* controller
* service
* repository
* entity
* dto
* exception
* security
* config

---

## API Endpoints

### User APIs

* POST /users
* GET /users
* PATCH /users/{id}/status

### Financial Record APIs

* POST /records
* GET /records
* PUT /records/{id}
* DELETE /records/{id}

### Filter APIs

* GET /records/filter/type?type=income
* GET /records/filter/category?category=salary

### Dashboard APIs

* GET /dashboard/summary
* GET /dashboard/category-summary

---

## Role Access Logic

The application uses a simple header-based role system.

Header:
ROLE = ADMIN

Only ADMIN can:

* Create records
* Update records
* Delete records

This approach was chosen as a simplified access-control implementation for assessment purposes.

---

## Database Configuration

MySQL database used:
finance_dashboard

Update application.properties with your local credentials before running.

---

## How to Run

1. Create MySQL database:
   CREATE DATABASE finance_dashboard;

2. Configure application.properties

3. Run the Spring Boot application

4. Test APIs using Postman

---

## Assumptions

* Authentication is simplified using request headers instead of JWT
* Aggregation logic is handled in service layer for simplicity
* Focus is on backend logic and maintainability rather than production deployment

---

## Future Improvements

* JWT Authentication
* Date-based filtering
* Monthly trend analytics
* Full role separation for Analyst and Viewer
* Pagination and search support
