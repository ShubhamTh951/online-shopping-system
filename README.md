# Online Shopping System (Java + JDBC + PostgreSQL)

A console-based Java application that simulates a real-world e-commerce system with database integration using JDBC and PostgreSQL.

This project demonstrates both core Object-Oriented Programming (OOP) concepts and backend development principles such as DAO architecture, layered design, transaction handling, and relational database modeling.

---

## Features

* User management with roles (Customer, Admin)
* Product catalog with stock and availability handling
* Shopping cart with quantity-based item management
* Order placement with database persistence
* Payment processing (UPI simulation)
* Automatic user creation and retrieval from database
* Order and order-items relational mapping (Many-to-Many)
* Clean layered architecture (DAO + Service)

---

## Architecture

MainApp (UI Layer)
↓
Service Layer (Business Logic)
↓
DAO Layer (Database Access)
↓
PostgreSQL Database

---

## Modules

### User Management

* User (abstract base class)
* Customer
* Admin

### Product Management

* Product model with stock handling

### Cart

* Add, remove, update items
* Calculate total amount

### Order System

* Order creation from cart
* Order status tracking
* Order-items mapping

### Payment System

* PaymentMethod (interface)
* UPIPayment (implementation)

### DAO Layer

* ProductDAO
* UserDAO
* OrderDAO

### Services

* InventoryService
* OrderService

---

## Technologies Used

* Java (Core)
* JDBC (Java Database Connectivity)
* PostgreSQL
* Object-Oriented Programming (OOP)
* Collections Framework (Map, List)
* Git & GitHub

---

## Database Schema

Tables used:

* users
* products
* orders
* order_items

Relational design with foreign key constraints and normalization.

---

## How to Run

### 1. Compile

javac -cp "lib/postgresql-42.7.9.jar" -d out $(find src -name "*.java")

### 2. Run

java -cp "out:lib/postgresql-42.7.9.jar" com.project.onlineshop.app.MainApp
## Future Improvements

* Convert to REST API using Spring Boot
* Add authentication and authorization
* Implement order history for users
* Add concurrency handling (thread safety)
* Use connection pooling for performance optimization
