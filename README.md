# Books Management RESTful API

This is a Books Management RESTful API built using Spring Boot. It allows users to perform CRUD (Create, Read, Update, Delete) operations on a collection of books. The API is designed to be simple, scalable, and follows RESTful principles.

## Features
- **Create a new book**: Add a new book to the collection.
- **Retrieve all books**: Get a list of all books with pagination and filtering options.
- **Retrieve a single book**: Get details of a specific book by its ID.
- **Update a book**: Update the details of an existing book.
- **Delete a book**: Remove a book from the collection.
- **Error handling**: Proper error responses for invalid requests or server errors.
- **In-memory database**: Uses H2 database for easy setup and testing.

## Technologies Used
- **Spring Boot**: Backend framework for building the API.
- **Spring Data JPA**: For database operations.
- **H2 Database**: In-memory database for development and testing.
- **Lombok**: For reducing boilerplate code (optional).
- **Maven**: Dependency management and build tool.

## API Endpoints

### Base URL
```
http://localhost:8080/api/v1/books
```

### 1. Get All Books
**Method**: GET  
**Endpoint**: `/api/v1/books`  

**Query Parameters:**
- `page` (optional): Page number (default: 1).
- `limit` (optional): Number of books per page (default: 10).
- `genre` (optional): Filter books by genre.
- `author` (optional): Filter books by author.

**Example Request:**
```
GET /api/v1/books?page=1&limit=10&genre=Fiction
```

**Example Response:**
```json
{
  "data": [
    {
      "id": 1,
      "title": "The Great Gatsby",
      "author": "F. Scott Fitzgerald",
      "isbn": "9780743273565",
      "publishedDate": "1925-04-10",
      "genre": "Fiction",
      "publisher": "Scribner",
      "language": "English",
      "pageCount": 180,
      "coverImageUrl": "http://example.com/great-gatsby.jpg"
    }
  ],
  "pagination": {
    "page": 1,
    "limit": 10,
    "total": 100
  }
}
```

### 2. Get a Single Book
**Method**: GET  
**Endpoint**: `/api/v1/books/{id}`  

**Example Request:**
```
GET /api/v1/books/1
```

**Example Response:**
```json
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "isbn": "9780743273565",
  "publishedDate": "1925-04-10",
  "genre": "Fiction",
  "publisher": "Scribner",
  "language": "English",
  "pageCount": 180,
  "coverImageUrl": "http://example.com/great-gatsby.jpg"
}
```

### 3. Create a New Book
**Method**: POST  
**Endpoint**: `/api/v1/books`  

**Request Body:**
```json
{
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935",
  "publishedDate": "1949-06-08",
  "genre": "Dystopian",
  "publisher": "Secker & Warburg",
  "language": "English",
  "pageCount": 328,
  "coverImageUrl": "http://example.com/1984.jpg"
}
```

### 4. Update a Book
**Method**: PUT  
**Endpoint**: `/api/v1/books/{id}`  

**Request Body:**
```json
{
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935",
  "publishedDate": "1949-06-08",
  "genre": "Dystopian",
  "publisher": "Secker & Warburg",
  "language": "English",
  "pageCount": 328,
  "coverImageUrl": "http://example.com/1984.jpg"
}
```

### 5. Delete a Book
**Method**: DELETE  
**Endpoint**: `/api/v1/books/{id}`  

**Example Request:**
```
DELETE /api/v1/books/2
```

**Example Response:**
```json
{
  "message": "Book deleted successfully"
}
```

## Error Handling
The API returns appropriate error responses for invalid requests or server errors. Example:
```json
{
  "error": {
    "code": "404",
    "message": "Book not found"
  }
}
```

## Setup and Run

### Prerequisites
- Java 17 or higher
- Maven 3.x

### Steps to Run
1. Clone the repository:
```
git clone https://github.com/your-repo/books-management-api.git
cd books-management-api
```
2. Build the project:
```
mvn clean install
```
3. Run the application:
```
mvn spring-boot:run
```
4. Access the API at:
```
http://localhost:8080/api/v1/books
```

## Database Configuration
The application uses an H2 in-memory database for development.

**Access the H2 console at:**
```
http://localhost:8080/h2-console
```

**Use the following credentials:**
- **JDBC URL**: `jdbc:h2:mem:bookdb`
- **Username**: `sa`
- **Password**: (leave blank)

## Testing
Use tools like Postman or cURL to test the API endpoints.

**Example cURL commands:**
```
# Get all books
curl -X GET http://localhost:8080/api/v1/books

# Create a new book
curl -X POST http://localhost:8080/api/v1/books -H "Content-Type: application/json" -d '{
  "title": "1984",
  "author": "George Orwell",
  "isbn": "9780451524935",
  "publishedDate": "1949-06-08",
  "genre": "Dystopian",
  "publisher": "Secker & Warburg",
  "language": "English",
  "pageCount": 328,
  "coverImageUrl": "http://example.com/1984.jpg"
}'
```

## Contributing
Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Submit a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Contact
For any questions or feedback, please contact:
- **Your Name**
- **Email**: your.email@example.com
- **GitHub**: your-github-profile

