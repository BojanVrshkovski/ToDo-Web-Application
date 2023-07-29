#Todo Web Application

This is a simple Todo Web Application built using Java Spring for the backend and Angular for the frontend. The application allows users to manage their todo tasks, including adding, updating, and deleting tasks. The data is stored in an H2 in-memory database.
#Prerequisites

Before running the application, make sure you have the following installed:

    Java Development Kit (JDK) 8 or higher
    Node.js and npm (Node Package Manager)
    Angular CLI (Command Line Interface)
    Git

#Getting Started
#Backend

    Clone the repository to your local machine:

bash

git clone https://github.com/BojanVrshkovski/todo-web-app.git

    Open the backend project in your preferred Java IDE (e.g., IntelliJ, Eclipse).

    Build and run the Spring Boot application. The backend will be accessible at http://localhost:8080.

#Frontend

    Navigate to the frontend directory of the project:

bash

cd todo-web-app/todo

    Install the required dependencies:

bash

npm install

    Start the Angular development server:

bash

ng serve

The frontend will be accessible at http://localhost:4200.
#Features

    User Authentication: The application supports user authentication with a basic hardcoded authentication service. Users can log in and log out.

    Todo Management: Authenticated users can view, add, update, and delete their todo tasks. Each task includes a description, a target date, and a status (completed or not).

    Database: The application uses an H2 in-memory database, which means the data is not persistent and will be reset each time the application is restarted.

#Directory Structure

The project is structured as follows:

css

todo-web-app/
  ├── backend/
  │   ├── src/
  │   │   └── main/
  │   │       ├── java/
  │   │       │   └── com.example.todo/
  │   │       │       ├── config/
  │   │       │       ├── controller/
  │   │       │       ├── model/
  │   │       │       ├── repository/
  │   │       │       ├── service/
  │   │       │       └── TodoWebApplication.java
  │   │       └── resources/
  │   │           ├── application.properties
  │   │           ├── data.sql
  │   │           └── schema.sql
  │   └── pom.xml
  ├── frontend/
  │   ├── e2e/
  │   ├── src/
  │   │   ├── app/
  │   │   │   ├── components/
  │   │   │   ├── models/
  │   │   │   ├── services/
  │   │   │   └── app.component.ts
  │   │   └── ...
  │   ├── angular.json
  │   ├── package.json
  │   └── ...
  └── README.md

#Future Improvements

    Persist Data: Integrate a persistent database (e.g., MySQL, PostgreSQL) to store todo tasks permanently.

    User Registration: Implement user registration to allow new users to sign up.

    Task Categories: Add support for categorizing tasks, allowing users to group tasks under different categories or projects.

    Task Prioritization: Add priority levels to tasks to help users prioritize their work.

    Task Filtering and Sorting: Implement filtering and sorting options for tasks based on different criteria (e.g., due date, status).

#License

This project is licensed under the BV License.
#Acknowledgments

Thank you for using this Todo Web Application. Feedback and contributions are welcome!
