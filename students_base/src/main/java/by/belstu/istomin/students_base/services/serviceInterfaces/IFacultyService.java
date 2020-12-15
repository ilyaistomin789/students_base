package by.belstu.istomin.students_base.services.serviceInterfaces;

import by.belstu.istomin.students_base.model.Faculty;
import by.belstu.istomin.students_base.model.Subject;

import java.util.List;

public interface IFacultyService {
    List<Faculty> findAll();
    void addFaculty(String facultyName);
}
