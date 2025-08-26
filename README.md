# 🎮 RPG App

This is a **fullstack project** developed with **Java (Spring Boot)** for the backend and **React** for the frontend.
The main goal is to **practice and strengthen Java development skills**, database integration, best practices, and API-to-UI communication.

> ⚠️ **Important**: This project was created for **personal Java learning purposes**. It is not intended for production and **does not accept contributions** at this time.

---

## ✅ Project Goals

- Learn and apply **modern Java concepts** (JDK 21+).
- Build a **REST API** using **Spring Boot**.
- Integrate with a database using **JPA and Hibernate**.
- Practice **pagination, filters, and DTOs** on the backend.
- Consume the API with **React frontend**.
- Explore best practices for organization, testing, and documentation.

---

## 🛠️ Technologies Used

### **Backend**
- Java 21+
- Spring Boot (Web, Data JPA, Validation)
- Maven
- Database: H2 (development) and PostgreSQL (optional)
- Lombok

### **Frontend**
- React + Vite
- TypeScript
- Axios
- TailwindCSS (or other styling solution used)

---

## 📂 Project Structure

```

rpg-app/
├── backend/                  # Java Spring Boot REST API
│   ├── src/main/java/com/k1ngs/rpg\_backend/
│   │   ├── domain/           # Domain entities
│   │   ├── dto/              # Data Transfer Objects
│   │   ├── service/          # Business logic
│   │   ├── web/              # REST controllers
│   │   └── RpgBackendApplication.java
│   ├── src/test/java/...     # Unit and integration tests
│   └── pom.xml
│
└── frontend/                 # React interface
├── src/
│   ├── components/       # Reusable components
│   ├── pages/            # Main pages
│   └── App.tsx
├── package.json

````

---

## 🚀 How to Run the Project

### **Requirements**
- **Java 21+**
- **Maven 3.9+**
- **Node.js 18+**
- **npm** or **pnpm**

---

### **Backend**
```bash
cd backend
# Compile and run
mvn spring-boot:run
````

API will be available at:

```
http://localhost:8080/api/quests
```

---

### **Frontend**

```bash
cd frontend
# Install dependencies
npm install
# Run development server
npm run dev
```

UI available at:

```
http://localhost:5173
```

---

## ✅ Features

* Quest CRUD (create, list, filter by status)
* Pagination and sorting
* React integration to consume API

---

## 🧪 Tests

Run backend tests:

```bash
cd backend
mvn test
```

---

## ⚠️ Note

This project is **not production-ready** and may contain simplified implementations.
It was created **for learning purposes**, focusing on:

* Best practices with Spring Boot
* API and React integration
* Structuring a fullstack project

---

## 📚 Learning Resources

* [Spring Boot Documentation](https://spring.io/projects/spring-boot)
* [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
* [React + Vite Docs](https://vitejs.dev/guide/)
* Various Java & Spring tutorials on YouTube

