📘 Blog Management REST API

A secure and scalable RESTful Blog Management System built using Spring Boot, providing APIs for creating, reading, updating, and deleting blog posts with proper architecture and best practices.

🚀 Features
Create, update, delete blog posts
Get all blogs / single blog by ID
RESTful API design
Layered architecture (Controller, Service, Repository)
Exception handling
Validation support
JSON-based communication
Easy to integrate with frontend (React/Angular)
🏗️ Tech Stack
Java
Spring Boot
Spring Web
Spring Data JPA
Hibernate
MySQL / H2 Database
Maven
📁 Project Structure
blog-api/
│
├── src/main/java/com/example/blog
│   ├── controller
│   ├── service
│   ├── service/impl
│   ├── repository
│   ├── entity
│   ├── exception
│   └── payload (DTOs)
│
├── src/main/resources
│   ├── application.properties
│
└── pom.xml
⚙️ Setup Instructions
1️⃣ Clone Repository
git clone https://github.com/pranjalKumarglbtim/BlogManagementRestAPI.git
cd BlogManagementRestAPI
2️⃣ Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/blogdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3️⃣ Run Project

Using Maven:

mvn spring-boot:run

Or run main class:

BlogApplication.java
📡 API Endpoints
🔹 Create Blog
POST /api/posts

Request Body:

{
  "title": "My First Blog",
  "content": "This is my blog content",
  "category": "Tech"
}
🔹 Get All Blogs
GET /api/posts
🔹 Get Blog by ID
GET /api/posts/{id}
🔹 Update Blog
PUT /api/posts/{id}
🔹 Delete Blog
DELETE /api/posts/{id}
❌ Exception Handling
Resource Not Found Exception
Global Exception Handler
Proper HTTP status codes (404, 400, 500)
📦 Sample Response
{
  "id": 1,
  "title": "Spring Boot Basics",
  "content": "Learn Spring Boot step by step",
  "category": "Education"
}
🔒 Future Improvements
JWT Authentication
Role-based access (Admin/User)
Pagination & Sorting
Swagger API documentation
Frontend integration (React/Angular)
Docker deployment
👨‍💻 Author

Pranjal Kumar

 
full SaaS-level architecture (microservices style)

bas bol dena 👍
