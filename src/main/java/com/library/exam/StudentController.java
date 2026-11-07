
package com.library.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello! Student Microservice deployed successfully!";
    }

    @GetMapping("/student")
    public String getStudent() {
        return "Student Name: Sampath Kumar, Branch: CSE";
    }

    @GetMapping("/status")
    public String status() {
        return "Microservice Status: RUNNING";
    }
}
