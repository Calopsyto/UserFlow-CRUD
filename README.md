# 🚀 UserFlow CRUD

<div align="center">

![Java](https://img.shields.io/badge/Java-26-orange?style=for-the-badge&logo=openjdk)
![JDBC](https://img.shields.io/badge/JDBC-Database-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql)
![Status](https://img.shields.io/badge/Status-Learning_Project-green?style=for-the-badge)

### ✨ Simple User Management CRUD Application built with Java + JDBC ✨

</div>

---

# 📖 About The Project

**UserFlow CRUD** is a simple Java CRUD application created to practice backend development and database integration using JDBC.

The project focuses on:

- 🧩 Clean code organization
- 🔌 JDBC database connectivity
- 🛠️ PreparedStatement usage
- 🗄️ MySQL integration
- ⚡ SQL operations
- 📦 CRUD fundamentals

---

# ⚙️ Features

## ✅ Create Users
Insert new users into the database.

## 📄 Read Users
Retrieve user information from MySQL.

## ✏️ Update Users
Modify existing user data.

## ❌ Delete Users
Remove records safely from the database.

---

# 🧠 Technologies Used

## ☕ Backend
- Java
- JDBC

## 🗄️ Database
- MySQL

## 💻 IDE
- IntelliJ IDEA

---

# 📂 Project Structure

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

# 🔥 Example JDBC Code

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

# 🛡️ Why Use PreparedStatement?

Using `PreparedStatement` provides several advantages:

- ✅ Prevents SQL Injection
- ✅ Improves security
- ✅ Makes code cleaner
- ✅ Allows dynamic parameters
- ✅ Better query handling

---

# 🚀 Getting Started

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/userflow-crud.git
```

---

## 2️⃣ Configure Database Connection

Update your database credentials:

```java
private static final String url = "jdbc:mysql://localhost:3306/your_database";
private static final String user = "root";
private static final String password = "your_password";
```

---

## 3️⃣ Run The Project

Run any desired class:

```txt
Insert.java
Update.java
Delete.java
Select.java
```

---

# 📸 Console Example

```txt
Rows affected: 1
Done! Id = 7
```

---

# 📚 Concepts Practiced

- JDBC Driver
- SQL Queries
- CRUD Operations
- ResultSet
- PreparedStatement
- Database Connection
- Exception Handling

---

# 🎯 Future Improvements

- [ ] Add DAO Pattern
- [ ] Create REST API
- [ ] Add Maven or Gradle
- [ ] Docker support
- [ ] Unit testing
- [ ] GUI Interface

---

# 🤝 Contributing

Contributions are welcome!

Feel free to fork the repository and submit pull requests.

---

# 📄 License

This project is licensed under the MIT License.

---

<div align="center">

## ⭐ If you liked this project, leave a star!

Made with ☕ Java and JDBC.

</div>
