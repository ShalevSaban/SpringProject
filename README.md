# 🎓 Student Management System – REST API

A robust backend system for managing students and grades, built with modern Java technologies and containerized for deployment. Designed as part of a full-stack bootcamp, the project demonstrates a production-ready microservice architecture with best practices in security, documentation, and scalability.

---

## 🛠️ Tech Stack

- **Java 17**, **Spring Boot**, **Maven**
- **PostgreSQL**
- **JPA & Hibernate**
- **REST API** with:
  - CRUD operations
  - Pagination, Sorting, Filtering
- **JWT-based Security**
- **Swagger** for API documentation
- **Docker**, **Docker Compose**, **Docker Hub**
- **AWS S3** – file uploads via pre-signed URLs
- **Asynchronous job processing**
- **Microservices architecture**
- **Global Exception Handling**
- **Spring Boot Actuator**
- **OpenShift-ready deployment**

---

## ✨ Key Features

- 🔐 **JWT Authentication** – secure access with role-based permissions
- 📊 **Student & Grade Management** – full CRUD with filtering and sorting
- 📂 **File Uploads** – handled via AWS S3 pre-signed links
- 📨 **Notification Microservice** – send SMS and email alerts
- 🚀 **Fully Dockerized** – ready for deployment with Docker & Compose
- 📈 **Monitoring** – integrated with Spring Boot Actuator endpoints
- 🌐 **API Documentation** – auto-generated Swagger UI

---

## 📦 Microservices

- **Student Service** – core business logic and data management
- **Notification Service** – handles SMS/email notifications
- **Gateway (optional)** – for routing and central authentication

---

## 🧪 Setup & Run

```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/student-management-system.git
cd student-management-system

# Run the application with Docker Compose
docker-compose up --build
