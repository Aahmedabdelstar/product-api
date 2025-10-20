# Product API 🛍️

A RESTful API built with Spring Boot for managing product inventory. This API can be accessed remotely by mobile applications.

## 🌐 Live API

**Base URL**: `https://your-app-name.onrender.com` (after deployment)

## 📋 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get a specific product by ID |
| POST | `/api/products` | Create a new product |
| PUT | `/api/products/{id}` | Update an existing product |
| DELETE | `/api/products/{id}` | Delete a product |

## 🔧 Technologies Used

- **Java 21**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Lombok**
- **Maven**

## 🚀 Running Locally

### Prerequisites
- Java 21 or higher
- Maven

### Run the application

```bash
# Using Maven wrapper (Unix/Mac)
./mvnw spring-boot:run

# Using Maven wrapper (Windows)
mvnw.cmd spring-boot:run

# Or if you have Maven installed
mvn spring-boot:run
```

The API will start at: `http://localhost:8080`

### Test the API

```bash
# Get all products
curl http://localhost:8080/api/products

# Create a new product
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "New Product",
    "description": "Product description",
    "price": 29.99,
    "stockQuantity": 50
  }'
```

## 📱 Mobile Team Integration

### Example Request (Android/Kotlin)
```kotlin
val apiUrl = "https://your-app-name.onrender.com/api/products"

// Using Retrofit or OkHttp
```

### Example Request (iOS/Swift)
```swift
let apiUrl = "https://your-app-name.onrender.com/api/products"

// Using URLSession or Alamofire
```

### Example Request (React Native)
```javascript
const API_URL = 'https://your-app-name.onrender.com/api/products';

fetch(API_URL)
  .then(response => response.json())
  .then(data => console.log(data));
```

## 🌍 Deployment

See [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md) for detailed deployment instructions to:
- Render.com (Recommended - Free)
- Railway.app (Free $5 credit)
- Heroku

## 📦 Project Structure

```
product-api/
├── src/
│   ├── main/
│   │   ├── java/com/example/productapi/
│   │   │   ├── controller/
│   │   │   │   └── ProductController.java
│   │   │   ├── entity/
│   │   │   │   └── Product.java
│   │   │   ├── repository/
│   │   │   │   └── ProductRepository.java
│   │   │   └── ProductApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/
├── pom.xml
└── README.md
```

## 🔐 CORS Configuration

CORS is enabled to allow mobile apps to access the API. Currently configured to allow all origins (`*`). For production, update this in `application.properties`:

```properties
spring.web.cors.allowed-origins=https://yourdomain.com
```

## 📝 Sample Product Data

The API is pre-loaded with sample products defined in `data.sql`:

1. Laptop - $999.99
2. Smartphone - $699.99
3. Headphones - $199.99
4. Tablet - $499.99
5. Smartwatch - $299.99

## ⚠️ Important Notes

- This project uses H2 in-memory database, which means data is **not persistent** and will be reset on restart
- For production use with real data, consider migrating to PostgreSQL or MySQL
- Free tier hosting services may have cold start delays (first request after inactivity)

## 🤝 Contributing

Feel free to submit issues and enhancement requests!

## 📄 License

This project is for educational/demo purposes.

---

**Need help deploying?** Check out the [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md)!

