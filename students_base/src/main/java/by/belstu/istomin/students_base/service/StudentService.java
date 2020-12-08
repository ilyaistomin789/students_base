package by.belstu.istomin.students_base.service;

import by.belstu.istomin.students_base.models.Student;
import by.belstu.istomin.students_base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentService studentService;
    public List<Student> findAllStudents() {return studentService.findAllStudents();}
}
