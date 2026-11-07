
package com.library.exam;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    public StudentController() {
        students.add(new Student(1, "Sampath", "CSE"));
        students.add(new Student(2, "Rahul", "ECE"));
        students.add(new Student(3, "Kiran", "IT"));
    }

    // Existing APIs

    @GetMapping("/hello")
    public String hello() {
        return "Student Microservice deployed successfully!";
    }

    @GetMapping("/status")
    public String status() {
        return "Microservice Status: RUNNING";
    }

    // READ ALL
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // READ BY ID
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }

    // UPDATE
    @PutMapping("/students/{id}")
    public Student updateStudent(
            @PathVariable int id,
            @RequestBody Student updatedStudent) {

        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setBranch(updatedStudent.getBranch());
                return s;
            }
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {

        boolean removed = students.removeIf(
                s -> s.getId() == id);

        return removed
                ? "Student deleted successfully"
                : "Student not found";
    }
}
