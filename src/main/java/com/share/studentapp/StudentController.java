package com.share.studentapp;

import com.share.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// When you know that the returned data is JSON/XML by all the methods then we can make it RestController instead of making
// responseBody in all the methods
@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping(path="students", produces = {"application/xml"})
    public List<Student> getStudents() {
        List<Student> studentList = studentRepo.findAll();

        return studentList;
    }

    @GetMapping("students/{sid}")
    public Student getStudent(@PathVariable("sid") int sid) {
        Student studentList = studentRepo.findById(sid).orElse(new Student(0,""));

        return studentList;
    }

    @PostMapping(path="student", consumes = {"application/json"})
    public Student addStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }
}
