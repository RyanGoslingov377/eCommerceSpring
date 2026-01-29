E-Commerce Web Application (Spring Boot)
A modern, full-featured E-Commerce Platform built with Spring Boot that provides a complete online shopping experience. This project implements industry-standard patterns and best practices for enterprise web application development.

🚀 Live Demo
Application URL: http://localhost:8081/

✨ Key Features
👤 Customer Experience
User Registration & Authentication - Secure signup/login with session management

Product Catalog - Browse products with categories and filtering

Shopping Cart - Add/remove items, quantity management

Order Management - Place orders, track order history

Responsive UI - Mobile-friendly interface with Bootstrap

🛠️ Admin Dashboard
Product Management - Full CRUD operations for products

Inventory Control - Stock management and tracking

Category Management - Organize products into categories

User Management - View and manage registered users

Order Processing - Process and manage customer orders

🏗️ Architecture & Technology Stack
Backend Layer
Java 11+ - Core programming language

Spring Boot 2.7+ - Rapid application development framework

Spring MVC - Model-View-Controller architecture

Spring Data JPA - Database abstraction layer

Spring Security - Authentication and authorization

Hibernate - ORM implementation

Frontend Layer
JSP (JavaServer Pages) - Dynamic web pages

Bootstrap 5 - Responsive CSS framework

JavaScript - Client-side interactivity

AJAX - Asynchronous data loading

jQuery - Simplified DOM manipulation

Data Layer
MySQL 8.0 - Relational database management

JPA/Hibernate - Object-relational mapping

Connection Pooling - Optimized database connections

Infrastructure
Apache Maven - Build automation and dependency management

Apache Tomcat - Embedded servlet container

Git - Version control system

GitHub - Source code repository and collaboration

📁 Project Structure

ecommerce-spring-project/
├── src/main/java/com/jtspringproject/
│   ├── JtSpringProjectApplication.java     # Main application class
│   ├── configuration/                      # Configuration classes
│   │   ├── HibernateConfiguration.java
│   │   └── SecurityConfiguration.java
│   ├── controller/                         # MVC Controllers
│   │   ├── AdminController.java
│   │   ├── UserController.java
│   │   └── ProductController.java
│   ├── service/                           # Business logic layer
│   │   ├── UserService.java
│   │   ├── ProductService.java
│   │   └── CartService.java
│   ├── dao/                               # Data access layer
│   │   ├── UserDao.java
│   │   ├── ProductDao.java
│   │   └── CategoryDao.java
│   ├── model/                             # Entity classes
│   │   ├── User.java
│   │   ├── Product.java
│   │   ├── Category.java
│   │   └── Cart.java
│   └── util/                              # Utility classes
│       └── PasswordHash.java
├── src/main/resources/
│   ├── application.properties             # Application configuration
│   ├── static/                            # Static resources
│   └── templates/                         # Thymeleaf templates
├── src/main/webapp/
│   ├── WEB-INF/
│   │   └── views/                         # JSP view files
│   │       ├── index.jsp
│   │       ├── login.jsp
│   │       ├── register.jsp
│   │       └── cart.jsp
│   └── assets/
│       ├── css/                           # Stylesheets
│       ├── js/                            # JavaScript files
│       └── images/                        # Image assets
├── pom.xml                               # Maven configuration
└── README.md                             # Project documentation

⚙️ Installation & Setup
Prerequisites
Java Development Kit (JDK 11 or higher)

MySQL Database Server (8.0 or higher)

Apache Maven (3.6+)

Git (for version control)

IDE (IntelliJ IDEA, Eclipse, or VS Code recommended)

Step 1: Clone the Repository
bash
git clone https://github.com/RyanGoslingov377/ecommercespring.git
cd ecommercespring
Step 2: Database Configuration
sql
-- Create database
CREATE DATABASE ecommerce_db;

-- Create user (optional)
CREATE USER 'ecommerce_user'@'localhost' IDENTIFIED BY 'secure_password';
GRANT ALL PRIVILEGES ON ecommerce_db.* TO 'ecommerce_user'@'localhost';
FLUSH PRIVILEGES;
Step 3: Application Configuration
Update src/main/resources/application.properties:

properties
# Server Configuration
server.port=8081
server.servlet.context-path=/

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true

# Logging Configuration
logging.level.com.jtspringproject=DEBUG
logging.file.name=logs/ecommerce-app.log

# Spring Security (if applicable)
spring.security.user.name=admin
spring.security.user.password=admin123
Step 4: Build and Run
Option A: Using Maven
bash
# Clean and build the project
mvn clean package

# Run the application
mvn spring-boot:run
Option B: Using IDE
Import as Maven project in your IDE

Locate JtSpringProjectApplication.java

Run as Spring Boot application

Option C: Using Executable JAR
bash
java -jar target/jtproject-0.0.1-SNAPSHOT.jar
Step 5: Access the Application
Main Application: http://localhost:8081/

Admin Dashboard: http://localhost:8081/admin

H2 Console (if using): http://localhost:8081/h2-console

📋 Default Credentials
Test Users
Role	Username	Password	Access
Admin	admin@example.com	admin123	Full system access
Customer	user@example.com	user123	Shopping features
🔧 API Endpoints
Public Endpoints
text
GET  /                 - Home page
GET  /products         - List all products
GET  /products/{id}    - View product details
POST /register         - User registration
POST /login            - User authentication
User Endpoints (Authenticated)
text
GET  /cart             - View shopping cart
POST /cart/add/{id}    - Add item to cart
POST /cart/remove/{id} - Remove item from cart
POST /checkout         - Process order
GET  /orders           - View order history
Admin Endpoints
text
GET  /admin/dashboard  - Admin dashboard
GET  /admin/products   - Manage products
POST /admin/products   - Add new product
PUT  /admin/products/{id} - Update product
DELETE /admin/products/{id} - Delete product
GET  /admin/users      - User management
GET  /admin/orders     - Order management
🧪 Testing
Unit Tests
bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=UserServiceTest

# Generate test coverage report
mvn jacoco:report
Integration Tests
bash
# Run integration tests
mvn verify -P integration-test
Postman Collection
Import the Ecommerce-API.postman_collection.json for API testing.

🚀 Deployment
Docker Deployment
dockerfile
# Dockerfile
FROM openjdk:11-jre-slim
COPY target/jtproject-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
bash
# Build Docker image
docker build -t ecommerce-app .

# Run container
docker run -p 8080:8080 --name ecommerce-container ecommerce-app
Cloud Deployment (Heroku)
bash
# Deploy to Heroku
heroku create ecommerce-spring-app
git push heroku main
heroku open
📊 Database Schema
sql
-- Users table
CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(50) UNIQUE NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
password VARCHAR(255) NOT NULL,
role ENUM('ADMIN', 'USER') DEFAULT 'USER',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Products table
CREATE TABLE products (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
description TEXT,
price DECIMAL(10, 2) NOT NULL,
category_id INT,
stock_quantity INT DEFAULT 0,
image_url VARCHAR(500),
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (category_id) REFERENCES categories(id)
);

-- Orders table
CREATE TABLE orders (
id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT NOT NULL,
total_amount DECIMAL(10, 2) NOT NULL,
status ENUM('PENDING', 'PROCESSING', 'SHIPPED', 'DELIVERED') DEFAULT 'PENDING',
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES users(id)
);
🔐 Security Features
Password Encryption - BCrypt password hashing

Session Management - HTTP session-based authentication

CSRF Protection - Cross-Site Request Forgery prevention

Input Validation - Server-side validation

SQL Injection Prevention - Parameterized queries

🛠️ Development Tools
Lombok - Reduced boilerplate code

Spring DevTools - Hot reload for development

Logback - Advanced logging configuration

ModelMapper - Object mapping utilities

📈 Monitoring & Logging
Application logs are stored in logs/ecommerce-app.log with rotation configuration. Key metrics include:

Request/response times

Database query performance

User activity tracking

Error and exception logging

🚧 Future Enhancements
Phase 2 (Next Release)
Payment gateway integration (Stripe/PayPal)

Advanced search with Elasticsearch

Product reviews and ratings

Email notifications

REST API documentation (Swagger/OpenAPI)

Phase 3 (Future)
Microservices architecture

Docker containerization

Kubernetes orchestration

CI/CD pipeline

Performance monitoring with Grafana

🤝 Contributing
Contributions are welcome! Please follow these steps:

Fork the repository

Create a feature branch (git checkout -b feature/AmazingFeature)

Commit changes (git commit -m 'Add AmazingFeature')

Push to branch (git push origin feature/AmazingFeature)

Open a Pull Request

Code Style Guidelines
Follow Google Java Style Guide

Write meaningful commit messages

Include unit tests for new features

Update documentation accordingly

📝 License
This project is licensed under the MIT License - see the LICENSE file for details.

👨‍💻 Author
Ryan Itkev

GitHub: @RyanGoslingov377
