package com.example.sis.service;

import com.example.sis.entity.Student;
import com.example.sis.entity.StudentScore;
import com.example.sis.entity.Subject;
import com.example.sis.repository.StudentRepository;
import com.example.sis.repository.StudentScoreRepository;
import com.example.sis.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentScoreRepository studentScoreRepository;

    public List<StudentScore> getAllScores() {
        return studentScoreRepository.findAll();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void saveScore(StudentScore score) {
        studentScoreRepository.save(score);
    }

    public double calculateScore(double score1, double score2) {
        return (0.3 * score1) + (0.7 * score2);
    }

    public String calculateGrade(double score1, double score2) {
        double finalScore = calculateScore(score1, score2);
        if (finalScore >= 8.0) {
            return "A";
        } else if (finalScore >= 6.0) {
            return "B";
        } else if (finalScore >= 4.0) {
            return "D";
        } else {
            return "F";
        }
    }
}