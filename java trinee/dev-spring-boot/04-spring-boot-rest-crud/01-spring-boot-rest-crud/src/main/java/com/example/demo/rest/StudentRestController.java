package com.example.demo.rest;

import com.example.demo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;
    @PostMapping
    public void load(){
        students = new ArrayList<>();
        students.add(new Student("Poornima","Patel"));
        students.add(new Student("Mario","Rossi"));
        students.add(new Student("Mary","Smith"));


    }

    //DEFINE ENDPOINT FOR "/students"-RETURN A LIST OF STUDENTS
    @GetMapping("/student")
    public List<Student> getStudents(Student student) {
        return students;
    }

    //DEFINING ENDPOINT FOR "/students/{studentID}"-RETURN STUDENT AT INDEX
    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID) {
        if(studentID < 1 || studentID > students.size()){
            throw new StudentNotFoundException("Student ID is invalid "+studentID);
        }

        return students.get(studentID);
    }

}
