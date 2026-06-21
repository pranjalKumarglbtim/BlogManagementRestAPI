# Blog Management REST API - Technical Documentation

## API Reference

### User Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/users` | Create a new user | No |
| GET | `/api/users` | Get all users | No |
| GET | `/api/users/{id}` | Get user by ID | No |
| PUT | `/api/users/{id}` | Update user | No |
| DELETE | `/api/users/{id}` | Delete user | No |

### Post Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/posts` | Create a new post | No |
| GET | `/api/posts` | Get all posts | No |
| GET | `/api/posts/{id}` | Get post by ID | No |
| PUT | `/api/posts/{id}` | Update post | No |
| DELETE | `/api/posts/{id}` | Delete post | No |

### Category Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/categories` | Create a new category | No |
| GET | `/api/categories` | Get all categories | No |
| GET | `/api/categories/{id}` | Get category by ID | No |
| PUT | `/api/categories/{id}` | Update category | No |
| DELETE | `/api/categories/{id}` | Delete category | No |

---

## Database Schema

### Users Table

```sql
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    about VARCHAR(500)
);
```

### Posts Table

```sql
CREATE TABLE posts (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    user_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (category_id) REFERENCES categories(id)
);
```

### Categories Table

```sql
CREATE TABLE categories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(500)
);
```

---

## Request/Response Formats

### User

**Create/Update Request:**
```json
{
  "name": "string",
  "email": "string",
  "password": "string",
  "about": "string"
}
```

**Response:**
```json
{
  "id": 0,
  "name": "string",
  "email": "string",
  "password": "string",
  "about": "string"
}
```

### Post

**Create/Update Request:**
```json
{
  "title": "string",
  "content": "string",
  "user": {
    "id": 0
  },
  "category": {
    "id": 0
  }
}
```

**Response:**
```json
{
  "id": 0,
  "title": "string",
  "content": "string",
  "user": {
    "id": 0,
    "name": "string",
    "email": "string",
    "password": "string",
    "about": "string"
  },
  "category": {
    "id": 0,
    "title": "string",
    "description": "string"
  }
}
```

### Category

**Create/Update Request:**
```json
{
  "title": "string",
  "description": "string"
}
```

**Response:**
```json
{
  "id": 0,
  "title": "string",
  "description": "string"
}
```

---

## Error Responses

| HTTP Status | Description |
|-------------|-------------|
| 400 | Bad Request - Invalid input |
| 404 | Not Found - Resource not found |
| 500 | Internal Server Error |

**Error Response Format:**
```json
{
  "timestamp": "2025-06-22T10:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Resource not found",
  "path": "/api/users/999"
}
```

---

## Architecture

The application follows a layered architecture:

- **Controller Layer**: Handles HTTP requests/responses
- **Service Layer**: Contains business logic
- **Repository Layer**: Data access layer using Spring Data JPA
- **Entity Layer**: JPA entity definitions

---

## Dependencies

### Core Framework
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA

### Database
- H2 Database (Development)
- PostgreSQL (Production)

### Tools
- Lombok
- SpringDoc OpenAPI 2.8.9
- Maven

---

## Configuration

### Application Properties

- Server Port: 8080
- Database: H2 in-memory (Development)
- JPA: Hibernate with auto DDL update
- Swagger UI: Enabled at `/swagger-ui/index.html`
- H2 Console: Enabled at `/h2-console`

---

## Build Commands

```bash
# Clean and build
./mvnw clean install

# Run application
./mvnw spring-boot:run

# Run tests
./mvnw test
```

---

## API Documentation

Swagger UI is available at:
```
http://localhost:8080/swagger-ui/index.html
```

OpenAPI specification at:
```
http://localhost:8080/v3/api-docs
```
