# Student Management System

A comprehensive JavaFX-based desktop application for managing student records, courses, and grades in an educational institution.

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technology Stack](#technology-stack)
- [System Requirements](#system-requirements)
- [Installation](#installation)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [API Documentation](#api-documentation)
- [Contributing](#contributing)
- [License](#license)

## 🎯 Overview

The Student Management System is a desktop application built with JavaFX that provides a complete solution for educational institutions to manage student information, course offerings, and academic grades. The system features an intuitive graphical user interface with comprehensive CRUD operations and real-time data visualization.

## ✨ Features

### 🏠 Dashboard
- **Real-time Statistics**: Display total enrolled students, male/female enrollment counts
- **Interactive Charts**: 
  - Bar chart for total enrollment trends
  - Area chart for female enrollment visualization
  - Line chart for male enrollment tracking
- **Visual Analytics**: Time-based enrollment data with graphical representations

### 👨‍🎓 Student Management
- **Complete Student Records**: Store personal information including name, student number, birth date, gender, and status
- **Image Support**: Upload and display student photos
- **CRUD Operations**: Add, update, delete, and view student records
- **Search & Filter**: Real-time search across all student fields
- **Status Tracking**: Monitor enrollment status (Enrolled, Not Enrolled, Inactive)
- **Academic Year Management**: Track students across different academic years

### 📚 Course Management
- **Course Catalog**: Maintain comprehensive course listings
- **Course Details**: Store course name, description, and degree information
- **Dynamic Course Lists**: Automatically populate course dropdowns
- **Course CRUD**: Full create, read, update, delete operations for courses

### 📊 Grade Management
- **Semester Grading**: Track first semester and second semester grades
- **Automatic Calculation**: System calculates final grades as average of both semesters
- **Grade History**: Maintain complete academic records for each student
- **Search Functionality**: Quick search through grade records

### 🔐 Security & Authentication
- **Login System**: Secure user authentication
- **Session Management**: Proper user session handling
- **Logout Functionality**: Secure session termination

### 🎨 User Interface
- **Modern Design**: Clean, professional interface with CSS styling
- **Drag & Drop**: Moveable application window
- **Responsive Layout**: Adaptable interface components
- **Window Controls**: Custom minimize and close buttons
- **Form Validation**: Input validation with user-friendly error messages

## 🛠 Technology Stack

- **Frontend**: JavaFX 11+
- **Backend**: Java 11+
- **Database**: MySQL 8.0+
- **Build Tool**: Apache Ant
- **IDE**: NetBeans (recommended)
- **JDBC Driver**: MySQL Connector/J

## 💻 System Requirements

### Minimum Requirements
- **OS**: Windows 10, macOS 10.14, or Linux (Ubuntu 18.04+)
- **Java**: JDK 11 or higher
- **RAM**: 4GB minimum, 8GB recommended
- **Storage**: 500MB available space
- **Database**: MySQL Server 8.0+

### Development Requirements
- **IDE**: NetBeans 12+ or IntelliJ IDEA
- **Build Tool**: Apache Ant
- **Database Tool**: MySQL Workbench (optional)

## 🚀 Installation

### 1. Prerequisites
```bash
# Verify Java installation
java -version

# Verify MySQL installation
mysql --version
```

### 2. Clone Repository
```bash
git clone https://github.com/Uthumnalinda/Student-Management-System.git
cd Student-Management-System
```

### 3. Database Configuration
Update the database connection in `src/studentmanagementsystem/database.java`:
```java
Connection connect = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/studentdata?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Asia/Colombo",
    "your_username",
    "your_password"
);
```

### 4. Build and Run
```bash
# Using Apache Ant
ant clean
ant compile
ant run
```

## 🗄 Database Setup

### 1. Create Database
```sql
CREATE DATABASE studentdata;
USE studentdata;
```

### 2. Create Tables
```sql
-- Students table
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentNum INT UNIQUE NOT NULL,
    year VARCHAR(50),
    course VARCHAR(100),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    gender VARCHAR(10),
    birth DATE,
    status VARCHAR(20),
    image TEXT,
    date DATE
);

-- Courses table
CREATE TABLE course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course VARCHAR(100) UNIQUE NOT NULL,
    description TEXT,
    degree VARCHAR(100)
);

-- Student grades table
CREATE TABLE student_grade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentNum INT,
    year VARCHAR(50),
    course VARCHAR(100),
    first_sem DECIMAL(5,2) DEFAULT 0,
    second_sem DECIMAL(5,2) DEFAULT 0,
    final DECIMAL(5,2) DEFAULT 0,
    FOREIGN KEY (studentNum) REFERENCES student(studentNum) ON DELETE CASCADE
);

-- Admin/Login table (if needed)
CREATE TABLE admin (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

### 3. Insert Sample Data
```sql
-- Sample courses
INSERT INTO course (course, description, degree) VALUES
('Computer Science', 'Programming and software development', 'Bachelor of Science'),
('Mathematics', 'Pure and applied mathematics', 'Bachelor of Science'),
('Physics', 'Theoretical and experimental physics', 'Bachelor of Science');

-- Sample admin user
INSERT INTO admin (username, password) VALUES ('admin', 'admin');
```

## 📖 Usage

### 1. Login
- Launch the application
- Enter your credentials (default: admin/admin)
- Click Login

### 2. Dashboard Navigation
- **Home**: View statistics and charts
- **Add Students**: Manage student records
- **Available Course**: Manage course catalog
- **Student Grade**: Handle grade management

### 3. Student Management
1. Click "Add Students" tab
2. Fill in student information
3. Upload student photo (optional)
4. Select year, course, gender, and status
5. Click "ADD" to save

### 4. Course Management
1. Navigate to "Available Course" tab
2. Enter course name, description, and degree
3. Use ADD/UPDATE/DELETE buttons as needed

### 5. Grade Management
1. Go to "Student Grade" tab
2. Select a student record
3. Enter semester grades
4. System automatically calculates final grade

## 📁 Project Structure

```
Student-Management-System/
├── src/
│   └── studentmanagementsystem/
│       ├── StudentManagementSystem.java    # Main application class
│       ├── FXMLDocumentController.java     # Login controller
│       ├── dashboardController.java        # Main dashboard controller
│       ├── database.java                   # Database connection utility
│       ├── studentData.java               # Student data model
│       ├── courseData.java                # Course data model
│       ├── getData.java                   # Data utility class
│       ├── LoginForm.fxml                 # Login interface
│       ├── dashboard.fxml                 # Main dashboard interface
│       ├── loginDesign.css                # Login styling
│       └── dashboardDesign.css            # Dashboard styling
├── build/                                 # Compiled classes
├── lib/                                   # External libraries
├── build.xml                             # Ant build configuration
├── manifest.mf                           # JAR manifest
└── README.md                             # This file
```

## 🔧 API Documentation

### Core Classes

#### StudentManagementSystem.java
- **Purpose**: Main application entry point
- **Key Methods**:
  - `start(Stage stage)`: Initialize JavaFX application
  - `main(String[] args)`: Application entry point

#### dashboardController.java
- **Purpose**: Main application logic and UI control
- **Key Methods**:
  - `addStudentsAdd()`: Add new student record
  - `addStudentsUpdate()`: Update existing student
  - `addStudentsDelete()`: Remove student record
  - `availableCourseAdd()`: Add new course
  - `studentGradesUpdate()`: Update student grades
  - `homeDisplayTotalEnrolledStudents()`: Calculate enrollment statistics

#### database.java
- **Purpose**: Database connection management
- **Key Methods**:
  - `connectDb()`: Establish MySQL connection

### Data Models

#### studentData.java
- **Fields**: studentNum, year, course, firstName, lastName, gender, birth, status, image
- **Purpose**: Student record representation

#### courseData.java
- **Fields**: course, description, degree
- **Purpose**: Course information model

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### Code Style Guidelines
- Follow Java naming conventions
- Add comments for complex logic
- Maintain consistent indentation
- Include error handling

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🐛 Troubleshooting

### Common Issues

1. **Database Connection Error**
   - Verify MySQL server is running
   - Check database credentials in `database.java`
   - Ensure database exists

2. **JavaFX Runtime Error**
   - Verify JavaFX is properly installed
   - Check Java version compatibility

3. **Build Errors**
   - Ensure all dependencies are in `lib/` folder
   - Verify Java classpath configuration

## 📞 Support

For questions, issues, or contributions:
- **GitHub Issues**: [Create an issue](https://github.com/Uthumnalinda/Student-Management-System/issues)
- **Author**: [@Uthumnalinda](https://github.com/Uthumnalinda)

---

**Note**: This application is designed for educational purposes and local deployment. For production use, consider implementing additional security measures, input validation, and database optimization.
