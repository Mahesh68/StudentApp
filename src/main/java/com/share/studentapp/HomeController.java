package com.share.studentapp;

import com.share.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    StudentRepo studentRepo;

    @ModelAttribute
    public void modelData(Model m) {
        m.addAttribute("name", "students");
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("add")
    public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {
        int num3  = i+j;
        m.addAttribute("num3", num3);
        return "result";
    }

    @PostMapping(value="addStudent")
    public String addStudent(Student s) {
        studentRepo.save(s);
        return "result";
    }

    @GetMapping(value="getStudents")
    public String getStudents(Model m) {
//        List<Student> studentList = Arrays.asList(new Student(1, "Mahi"), new Student(3, "Sailu"));
        List<Student> studentList = studentRepo.findAll();

        m.addAttribute("result", studentList);
        return "showStudents";
    }

    @GetMapping(value="getStudent")
    public String getStudent(@RequestParam("sid") int sid1, Model m) {
//        Student student = studentRepo.findById(sid).orElse(new Student(10,"name"));
        m.addAttribute("result", studentRepo.getOne(sid1));
        return "showStudents";

    }

    @GetMapping(value="getStudentByName")
    public String getStudentByName(@RequestParam String sname, Model m) {
        m.addAttribute("result", studentRepo.findBySnameOrderBySidDesc(sname));
        return "showStudents";

    }

}
