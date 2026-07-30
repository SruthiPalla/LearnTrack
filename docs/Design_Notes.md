# Design Notes

## Why ArrayList?

ArrayList was chosen because it can dynamically increase or decrease in size during runtime.

Unlike arrays, there is no need to specify a fixed size in advance.

---

## Why Static Members?

The IdGenerator class uses static variables and static methods.

This ensures every Student, Course, and Enrollment receives a unique ID without creating an object of IdGenerator.

---

## Why Inheritance?

Person is the parent class.

Student and Trainer inherit common properties such as:

- id
- firstName
- lastName
- email

This reduces code duplication and improves code reusability.

---

## Why Service Classes?

Business logic is separated from the user interface.

StudentService manages student operations.

CourseService manages course operations.

EnrollmentService manages enrollment operations.

Main.java only handles user interaction and menu navigation.

This separation makes the application easier to maintain.