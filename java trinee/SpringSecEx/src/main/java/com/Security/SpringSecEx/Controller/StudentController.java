package com.Security.SpringSecEx.Controller;

import com.Security.SpringSecEx.model.student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StudentController {
    private List<student>  students=  new ArrayList<>(List.of(
            new student(1,"asd",50),
            new student(2,"qwe",60)
    ));
    @GetMapping("/student")
    public List<student> getStudents() {
        return students;
    }
    @GetMapping("/csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");

    }
    @PostMapping("/student")
    public student addStudent(@RequestBody student student) {
        students.add(student);
        return student;
    }
}
