package com.example.sis.controller;

import com.example.sis.entity.Student;
import com.example.sis.entity.StudentScore;
import com.example.sis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listScores", studentService.getAllScores());
        model.addAttribute("listStudents", studentService.getAllStudents());
        model.addAttribute("listSubjects", studentService.getAllSubjects());
        model.addAttribute("studentService", studentService);
        return "index";
    }

    @GetMapping("/students/new")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/students/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/scores/new")
    public String showAddScoreForm(Model model) {
        model.addAttribute("scoreObj", new StudentScore());
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("subjects", studentService.getAllSubjects());
        return "add_score";
    }

    @PostMapping("/scores/save")
    public String saveScore(@ModelAttribute("scoreObj") StudentScore scoreObj) {
        studentService.saveScore(scoreObj);
        return "redirect:/";
    }
}