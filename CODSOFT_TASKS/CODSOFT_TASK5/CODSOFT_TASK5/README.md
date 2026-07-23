# Course Registration System

A Core Java console application built for **CODSOFT Java Development Internship — Task 5**.

## Overview

This application simulates a simple course registration system for an educational
institution. It allows students to view available courses, register for courses,
drop courses they no longer want, and view their current registrations — all from
a text-based console menu.

No external libraries, frameworks, or build tools are used. The project is 100%
Core Java and can be opened and run directly in **IntelliJ IDEA Community Edition**
with **Java 17 or above**.

## Features

1. **View Available Courses** — Lists every course with its code, title,
   description, schedule, capacity and number of available seats.
2. **Register for a Course** — Prompts for a Student ID (creating a new student
   profile automatically if the ID is new) and a Course Code, then registers the
   student if a seat is available and they are not already registered.
3. **Drop a Course** — Lets a student remove themselves from a course they are
   currently registered in, freeing up a seat for someone else.
4. **View Registered Courses** — Displays full details of every course a given
   student is currently registered for.
5. **Exit** — Cleanly terminates the application.

## Validation Rules Implemented

- Duplicate registration for the same course is blocked.
- Registration is blocked once a course reaches full capacity.
- Dropping a course the student is not registered in is blocked.
- Available seats are updated immediately after every registration and drop.
- Invalid / non-numeric menu choices are handled gracefully.
- Invalid or unknown course codes are detected and reported.
- Every operation prints a clear success or error message.

## Project Structure

```
CourseRegistrationSystem/
│
├── src/
│   ├── Course.java                   # Course entity (code, title, description, capacity, schedule)
│   ├── Student.java                  # Student entity (ID, name, registered course codes)
│   ├── CourseDatabase.java           # In-memory store + lookup/listing for courses
│   ├── StudentDatabase.java          # In-memory store + lookup/creation for students
│   ├── CourseRegistrationSystem.java # Console menu + business logic
│   └── Main.java                     # Application entry point
│
├── README.md
└── .gitignore
```

## Class Design

- **Course** — Encapsulates all course data with private fields, a constructor,
  and getters. Tracks the number of registered students internally and exposes
  `reserveSeat()` / `releaseSeat()` to safely manage capacity.
- **Student** — Encapsulates student data with private fields, a constructor,
  and getters. Maintains an `ArrayList<String>` of registered course codes.
- **CourseDatabase** — Owns an `ArrayList<Course>`, pre-loaded with sample
  courses, and provides lookup/listing methods.
- **StudentDatabase** — Owns an `ArrayList<Student>` and provides lookup and
  creation methods.
- **CourseRegistrationSystem** — Orchestrates the console menu loop and
  implements the registration/drop/view workflows, using the two databases.
- **Main** — Creates a `CourseRegistrationSystem` and starts it.

## How to Run in IntelliJ IDEA Community Edition

1. Open IntelliJ IDEA → **File → Open** → select the `CourseRegistrationSystem`
   folder.
2. If prompted, set the **Project SDK** to Java 17 or above
   (**File → Project Structure → Project → SDK**).
3. Locate `src/Main.java` in the Project pane.
4. Right-click `Main.java` → **Run 'Main.main()'**.
5. Use the on-screen menu (options 1–5) to interact with the system.

## How to Run from the Command Line

```bash
cd CourseRegistrationSystem
javac -d out src/*.java
java -cp out Main
```

## Sample Usage

```
1. View Available Courses
2. Register for a Course
3. Drop a Course
4. View Registered Courses
5. Exit
Enter your choice (1-5): 2

--- Course Registration ---
Enter your Student ID: S001
Enter your Name: Alice
New student profile created for Alice.
...
Enter the Course Code to register: CS101
Success: You have been registered for CS101 - Introduction to Programming.
Remaining seats: 2
```

## Author Notes

This project was built as part of the CODSOFT Java Development Internship
program to demonstrate Core Java, Object-Oriented Programming principles
(encapsulation, constructors, classes/objects, ArrayLists, getters), and
console-based application design.
