# Brands API - Spring Boot REST Application

A comprehensive REST API built with Spring Boot for managing brand entities. This application demonstrates modern Spring Boot development practices including clean architecture, validation, exception handling, and API documentation.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [API Documentation](#api-documentation)
- [Usage Examples](#usage-examples)
- [Testing](#testing)
- [Architecture](#architecture)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

The Brands API is a RESTful web service that provides CRUD operations for managing brand entities. It follows Spring Boot best practices and implements a clean, layered architecture with proper separation of concerns.

### Key Capabilities
- Create, read, update, and delete brand entities
- Input validation and error handling
- In-memory data storage with UUID-based identification
- Comprehensive API documentation with Swagger/OpenAPI
- RESTful API design following HTTP standards

## ✨ Features

- **CRUD Operations**: Complete Create, Read, Update, Delete functionality for brands
- **Input Validation**: Bean validation with custom constraints
- **Exception Handling**: Global exception handling with proper HTTP status codes
- **API Documentation**: Auto-generated Swagger/OpenAPI documentation
- **Clean Architecture**: Layered architecture with separation of concerns
- **In-Memory Storage**: Thread-safe in-memory repository implementation
- **UUID Support**: Unique identifier generation for all entities
- **Timestamp Tracking**: Automatic creation and update timestamp management
- **Health Monitoring**: Spring Boot Actuator for application health checks

## 🛠 Technology Stack

- **Java 24**: Latest Java version with modern language features
- **Spring Boot 3.5.5**: Latest Spring Boot framework
- **Spring Web**: REST API development
- **Spring Validation**: Input validation framework
- **Spring Boot Actuator**: Application monitoring and health checks
- **Lombok**: Reduces boilerplate code
- **SpringDoc OpenAPI**: API documentation generation
- **Maven**: Dependency management and build tool
- **JUnit 5**: Testing framework (Spring Boot Test)

## 📁 Project Structure

```
src/
├── main/
│   ├── java/pt/ulusofona/cd/brand/
│   │   ├── BrandApplication.java          # Main application class
│   │   ├── controller/
│   │   │   └── BrandController.java      # REST controller
│   │   ├── service/
│   │   │   └── BrandService.java         # Business logic layer
│   │   ├── repository/
│   │   │   ├── BrandRepository.java      # Repository interface
│   │   │   ├── InMemoryRepository.java   # In-memory implementation
│   │   │   └── Identifiable.java         # Entity identification interface
│   │   ├── model/
│   │   │   ├── Brand.java                # Entity model
│   │   │   └── dto/
│   │   │       ├── BrandRequest.java     # Request DTO
│   │   │       └── BrandResponse.java    # Response DTO
│   │   ├── mapper/
│   │   │   └── BrandMapper.java          # Entity-DTO mapping
│   │   └── exception/
│   │       ├── BrandNotFoundException.java # Custom exception
│   │       └── GlobalExceptionHandler.java # Global exception handling
│   └── resources/
│       └── application.properties        # Application configuration
└── test/
    └── java/pt/ulusofona/cd/brand/
        └── BrandApplicationTests.java    # Integration tests
```

## 🔧 Prerequisites

Before running this application, ensure you have the following installed:

- **Java 24** or higher
- **Maven 3.6+** 
- **IDE** (IntelliJ IDEA, Eclipse, or VS Code recommended)

## 🚀 Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd spring-boot-brands
   ```

2. **Build the project**
   ```bash
   ./mvnw clean install
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Verify the application is running**
   - Application will start on `http://localhost:8080`
   - Health check available at `http://localhost:8080/actuator/health`
   - API documentation available at `http://localhost:8080/swagger-ui.html`

## 📚 API Documentation

The API documentation is automatically generated using SpringDoc OpenAPI and is available at:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON**: `http://localhost:8080/v3/api-docs`

### Base URL
```
http://localhost:8080/api/v1/brands
```

## 📖 Usage Examples

### 1. Create a Brand
```http
POST /api/v1/brands
Content-Type: application/json

{
  "name": "Nike"
}
```

**Response (201 Created):**
```json
{
  "id": "b8b91a55-0d00-4e49-bf69-62333a6f4f97",
  "name": "Nike"
}
```

### 2. Get All Brands
```http
GET /api/v1/brands
```

**Response (200 OK):**
```json
[
  {
    "id": "b8b91a55-0d00-4e49-bf69-62333a6f4f97",
    "name": "Nike"
  },
  {
    "id": "675b278e-32b7-4c7a-af00-69b9f73b1772",
    "name": "Apple"
  }
]
```

### 3. Get Brand by ID
```http
GET /api/v1/brands/{id}
```

**Response (200 OK):**
```json
{
  "id": "b8b91a55-0d00-4e49-bf69-62333a6f4f97",
  "name": "Nike"
}
```

### 4. Update a Brand
```http
PUT /api/v1/brands/{id}
Content-Type: application/json

{
  "name": "Nike Inc."
}
```

**Response (200 OK):**
```json
{
  "id": "b8b91a55-0d00-4e49-bf69-62333a6f4f97",
  "name": "Nike Inc."
}
```

### 5. Delete a Brand
```http
DELETE /api/v1/brands/{id}
```

**Response (204 No Content)**

### Error Responses

#### Brand Not Found (404)
```json
{
  "error": "Not Found",
  "message": "Brand with id 'invalid-uuid' not found",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

#### Validation Error (400)
```json
{
  "error": "Bad Request",
  "message": "Validation failed",
  "timestamp": "2024-01-15T10:30:00Z"
}
```

## 🧪 Testing

### Running Tests
```bash
# Run all tests
./mvnw test

# Run tests with coverage
./mvnw test jacoco:report
```

### Test Structure
- **Unit Tests**: Service layer business logic
- **Integration Tests**: Full application context testing
- **Controller Tests**: REST endpoint testing

## 🏗 Architecture

### Design Patterns
- **Repository Pattern**: Data access abstraction
- **DTO Pattern**: Data transfer objects for API communication
- **Mapper Pattern**: Entity-DTO conversion
- **Global Exception Handler**: Centralized error handling

### Layers
1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic
3. **Repository Layer**: Manages data persistence
4. **Model Layer**: Defines entities and DTOs

### Data Flow
```
HTTP Request → Controller → Service → Repository → In-Memory Storage
                ↓
HTTP Response ← DTO ← Entity ← Business Logic ← Data
```

## 📦 Dependencies

### Core Dependencies
- `spring-boot-starter-web`: Web application development
- `spring-boot-starter-validation`: Input validation
- `spring-boot-starter-actuator`: Production-ready features
- `spring-boot-starter-test`: Testing framework

### Development Dependencies
- `spring-boot-devtools`: Development tools and hot reload
- `lombok`: Reduces boilerplate code
- `springdoc-openapi-starter-webmvc-ui`: API documentation

## 🔧 Configuration

### Application Properties
```properties
spring.application.name=brand
```

### Default Configuration
- **Port**: 8080
- **Context Path**: `/`
- **Actuator Endpoints**: Enabled
- **Swagger UI**: Available at `/swagger-ui.html`

## 📝 Postman Collection

A Postman collection is included in the project root (`Brands.postman_collection.json`) with pre-configured requests for testing all API endpoints.

### Import Instructions
1. Open Postman
2. Click "Import"
3. Select the `Brands.postman_collection.json` file
4. Start testing the API endpoints

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

### Development Guidelines
- Follow Java coding conventions
- Write comprehensive tests
- Update documentation for new features
- Ensure all tests pass before submitting PR

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Check the API documentation at `/swagger-ui.html`
- Review the test cases for usage examples

---

**Built with ❤️ using Spring Boot**