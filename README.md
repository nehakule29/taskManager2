# Task Manager — Full Stack Application

A full-stack Task Manager application built with **React**, **Spring Boot**, and **MongoDB**.

The project demonstrates how a React frontend communicates with a Spring Boot REST API, which persists task data in MongoDB.

## 🚀 Features

* Create new tasks
* View all tasks
* Update existing tasks
* Delete tasks
* Mark tasks as completed
* RESTful API integration
* MongoDB persistence
* React state management
* Responsive and clean UI

## 🛠️ Tech Stack

### Frontend

* React
* JavaScript
* HTML
* CSS
* Fetch API

### Backend

* Java
* Spring Boot
* Spring Web
* Spring Data MongoDB
* REST APIs
* Maven

### Database

* MongoDB
* MongoDB Atlas *(for deployment)*

## 🏗️ Architecture

```text
React Frontend
      │
      │ HTTP Requests
      ▼
Spring Boot REST API
      │
      │ Spring Data MongoDB
      ▼
MongoDB
```

The application follows a layered backend architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MongoDB
```

The repository layer abstracts database operations from the rest of the application.

## 📌 REST API Endpoints

| Method | Endpoint                    | Description      |
| ------ | --------------------------- | ---------------- |
| GET    | `/api/v1/tasks/all`         | Get all tasks    |
| GET    | `/api/v1/tasks/{id}`        | Get a task by ID |
| POST   | `/api/v1/tasks/create`      | Create a task    |
| PUT    | `/api/v1/tasks/update/{id}` | Update a task    |
| DELETE | `/api/v1/tasks/delete/{id}` | Delete a task    |

### Example Task

```json
{
  "title": "Learn Spring Data MongoDB",
  "completed": false
}
```

## 📂 Project Structure

```text
TaskManager/
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   ├── AddTask.jsx
│   │   │   └── TaskList.jsx
│   │   ├── App.jsx
│   │   └── App.css
│   ├── package.json
│   └── ...
│
└── backend/
    ├── src/
    │   └── main/
    │       └── java/
    │           └── com/
    │               └── nehaapps/
    │                   └── taskmanager/
    │                       ├── controller/
    │                       ├── service/
    │                       ├── repository/
    │                       └── model/
    ├── pom.xml
    └── ...
```

## 💡 Key Concepts Practiced

This project was built to strengthen practical understanding of:

* React functional components
* `useState` and `useEffect`
* React conditional rendering
* Immutable state updates using `map()` and `filter()`
* JavaScript objects and arrays
* Fetch API and HTTP methods
* REST API design
* Spring Boot controllers
* Dependency Injection
* Spring Beans
* Spring Data repositories
* MongoDB CRUD operations
* MongoDB document modeling
* Controller → Service → Repository architecture
* Frontend-backend integration
* CORS configuration

## 🔄 CRUD Flow

### Create

```text
React
  ↓ POST
Spring Boot Controller
  ↓
Repository
  ↓
MongoDB
```

### Read

```text
React
  ↓ GET
Spring Boot Controller
  ↓
Repository
  ↓
MongoDB
  ↓
JSON Response
  ↓
React
```

### Update

```text
React
  ↓ PUT /tasks/{id}
Spring Boot
  ↓
Repository
  ↓
MongoDB
  ↓
Updated Task
  ↓
React State
```

### Delete

```text
React
  ↓ DELETE /tasks/{id}
Spring Boot
  ↓
Repository
  ↓
MongoDB
```

## ⚙️ Running Locally

### Backend

Navigate to the backend directory:

```bash
cd backend
```

Run the Spring Boot application:

```bash
./mvnw spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

### Frontend

Navigate to the frontend directory:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the development server:

```bash
npm run dev
```

The React application will typically run at:

```text
http://localhost:5173
```

## 🔐 Environment Variables

For production, sensitive configuration such as the MongoDB connection string should be stored using environment variables rather than committed to GitHub.

Example:

```properties
spring.data.mongodb.uri=${MONGODB_URI}
```

Frontend API configuration can similarly use an environment variable:

```text
VITE_API_URL=<your-backend-url>
```

## 🌐 Deployment

The intended deployment architecture is:

```text
React
  ↓
Vercel
  ↓
Spring Boot API
  ↓
MongoDB Atlas
```

The frontend and backend are deployed separately, with the React application communicating with the deployed Spring Boot REST API.

## 📚 What I Learned

This project helped me move from building individual CRUD operations to understanding how different layers of a full-stack application communicate.

In particular, I practiced separating responsibilities between the frontend, REST controller, service layer, repository layer, and database.

## 🔮 Future Improvements

* Authentication and authorization
* Task filtering and search
* Pagination and sorting
* Input validation
* Global exception handling
* Unit and integration testing
* DTOs
* API documentation with Swagger/OpenAPI
* Improved UI/UX
* Production deployment

## 👩‍💻 Author

**Neha**

A full-stack learning project focused on building practical applications with Java, Spring Boot, React, and MongoDB.
