# UserFlow CRUD

<div align="center">

![Java](https://img.shields.io/badge/Java-26-orange?style=for-the-badge&logo=openjdk)
![JDBC](https://img.shields.io/badge/JDBC-Database-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql)
![Status](https://img.shields.io/badge/Status-Learning_Project-success?style=for-the-badge)

### Simple User Management CRUD Application using Java and JDBC

</div>

---

# Overview

UserFlow CRUD is a simple Java application developed to demonstrate CRUD (Create, Read, Update, Delete) operations using JDBC and MySQL.

The project was created for learning purposes, focusing on backend development fundamentals, database communication, and clean code organization.

---

# Features

## Create
Insert new users into the database.

## Read
Retrieve and display stored user information.

## Update
Modify existing user records.

## Delete
Remove users from the database safely.

---

# Technologies

## Backend
- Java
- JDBC

## Database
- MySQL

## Development Tools
- IntelliJ IDEA

---

# Project Structure

```bash
src/
│
├── application/
│   ├── Insert.java
│   ├── Update.java
│   ├── Delete.java
│   └── Select.java
│
├── db/
│   ├── DB.java
│   ├── DbException.java
│   └── DbIntegrityException.java
│
└── model/
    └── entities/
        └── User.java
```

---

# Example JDBC Implementation

```java
PreparedStatement preparedStatement = connection.prepareStatement(
    "INSERT INTO user (Name, Email) VALUES (?, ?)",
    Statement.RETURN_GENERATED_KEYS
);

preparedStatement.setString(1, "Arthur");
preparedStatement.setString(2, "arthur@gmail.com");

int rowsAffected = preparedStatement.executeUpdate();
```

---

# PreparedStatement Advantages

Using `PreparedStatement` provides important benefits:

- Prevents SQL Injection
- Improves query readability
- Supports dynamic parameters
- Enhances security
- Improves maintainability

---

# Getting Started

## Clone the Repository

```bash
git clone https://github.com/your-username/userflow-crud.git
```

---

## Configure Database Connection

Update the database credentials in your connection class:

```java
private static final String url = "jdbc:mysql://localhost:3306/your_database";
private static final String user = "root";
private static final String password = "your_password";
```

---

## Run the Application

Execute the desired class:

```txt
Insert.java
Update.java
Delete.java
Select.java
```

---

# Console Output Example

```txt
Rows affected: 1
Generated Id: 7
```

---

# Concepts Practiced

- JDBC Driver
- SQL Queries
- CRUD Operations
- ResultSet
- PreparedStatement
- Database Connection Management
- Exception Handling

---

# Future Improvements

- Implement DAO Pattern
- Add REST API support
- Add Maven or Gradle
- Dockerize the application
- Add automated tests
- Create a graphical interface

---

# Contributing

Contributions are welcome.

Feel free to fork the repository and submit improvements through pull requests.

---

# License

This project is licensed under the MIT License.

---

<div align="center">

Built with Java and JDBC.

</div>
