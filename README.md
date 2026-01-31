# Online Shopping System (Java)

A console-based Java application developed to practice and demonstrate core **Object-Oriented Programming (OOP)** concepts using Java.  
The project simulates a basic e-commerce workflow including product browsing, cart management, order placement, and payment processing.

This project is built incrementally with a focus on **clean design, modular structure, and real-world modeling** rather than UI.

-------------------------------------------------------------

## Features

- User management with different roles (Customer, Admin)
- Product catalog with availability and stock handling
- Shopping cart with quantity-based item management
- Order creation from cart with order tracking
- Payment processing using an interface-based design (UPI implemented)
- Clear separation of concerns using packages and services

-------------------------------------------------------------

## Modules

- **User Management**
  - User (abstract base class)
  - Customer
  - Admin

- **Product Management**
  - Product model with stock and availability logic

- **Cart**
  - Add, remove, update items
  - Calculate total amount

- **Order Processing**
  - Create orders from cart
  - Maintain order status

- **Payment System**
  - PaymentMethod (interface)
  - UPIPayment (implementation)

- **Services**
  - OrderService
  - InventoryService

-------------------------------------------------------------

## Technologies & Concepts Used

- Java (Core)
- Object-Oriented Programming (OOP)
  - Inheritance
  - Abstraction
  - Encapsulation
  - Interfaces
- Collections Framework (`List`, `Map`)
- Modular package structure
- Command-line compilation and execution

-----------------------------------------------------------

## How to Run

# Compile all source files
javac -d out $(find src -name "*.java")

# Run the application
java -cp out com.project.onlineshop.app.MainApp
