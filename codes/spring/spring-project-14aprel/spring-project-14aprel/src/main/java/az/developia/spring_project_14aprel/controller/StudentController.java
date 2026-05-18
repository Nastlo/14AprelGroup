package az.developia.spring_project_14aprel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.spring_project_14aprel.entity.Student;

@Controller
public class StudentController {

    List<Student> students = new ArrayList<>();

    @GetMapping("/students")
    public String showPage(Model model) {

        model.addAttribute("students", students);

        return "students";
    }

    @PostMapping("/add-student")
    public String addStudent(
            @RequestParam String name,
            @RequestParam String surname,
            @RequestParam int grade) {

        Student student = new Student(name, surname, grade);

        students.add(student);

        return "redirect:/students";
    }
}