🚀 UserFlow CRUD
<div align="center">








✨ Simple User Management CRUD Application built with Java + JDBC ✨
</div>
📖 About The Project

UserFlow CRUD is a simple backend application developed in Java to practice database integration and CRUD operations using JDBC.

The project focuses on:

🧩 Clean code organization
🔌 Database connectivity
🛠️ PreparedStatement usage
📦 Basic SQL operations
⚡ JDBC fundamentals
🗄️ MySQL integration

This application allows you to manage users through classic CRUD operations:

Operation	Description
➕ Create	Insert new users into the database
📄 Read	Retrieve user information
✏️ Update	Edit existing user data
❌ Delete	Remove users from the database
🧠 Technologies Used
☕ Java
🗄️ MySQL
🔌 JDBC
💻 IntelliJ IDEA
📂 Project Structure
src/
│
├── application/
│   ├── Program.java
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
⚙️ Features
✅ Insert users into database
✅ Read user data
✅ Update existing records
✅ Delete records safely
✅ Exception handling
✅ PreparedStatement implementation
✅ Generated keys retrieval
🔥 Example SQL Query
INSERT INTO user
(Name, Email)
VALUES (?, ?)
💡 Example JDBC Code
PreparedStatement preparedStatement = connection.prepareStatement(
    "INSERT INTO user (Name, Email) VALUES (?, ?)",
    Statement.RETURN_GENERATED_KEYS
);

preparedStatement.setString(1, "Arthur");
preparedStatement.setString(2, "arthur@gmail.com");

int rowsAffected = preparedStatement.executeUpdate();
🛡️ Why PreparedStatement?

Using PreparedStatement helps:

Prevent SQL Injection
Improve query readability
Reuse SQL statements efficiently
Safely pass parameters
🧪 Learning Goals

This project was created to improve understanding of:

Relational databases
JDBC architecture
SQL execution in Java
Exception handling
Database connection management
🚀 Getting Started
1️⃣ Clone the repository
git clone https://github.com/your-username/userflow-crud.git
2️⃣ Configure the database

Create a MySQL database and update your connection credentials:

private static final String url = "jdbc:mysql://localhost:3306/your_database";
private static final String user = "root";
private static final String password = "your_password";
3️⃣ Run the project

Open the project in IntelliJ IDEA and run the desired class:

Insert.java
Update.java
Delete.java
Select.java
📸 Preview
Rows affected: 1
Done! Id = 7
📚 Concepts Practiced
JDBC Driver
SQL Queries
ResultSet
PreparedStatement
Transactions
CRUD Pattern
Exception Handling
🎯 Future Improvements
 Add GUI
 Implement DAO pattern
 Add Maven/Gradle
 Create REST API
 Add unit tests
 Docker support
🤝 Contributing

Contributions are welcome!

Feel free to fork the project and submit improvements.

📄 License

This project is licensed under the MIT License.

<div align="center">
⭐ If you liked this project, give it a star!

Made with ☕ and Java.

</div>
