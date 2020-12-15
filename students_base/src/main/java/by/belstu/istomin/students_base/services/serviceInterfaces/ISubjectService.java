package by.belstu.istomin.students_base.services.serviceInterfaces;

import by.belstu.istomin.students_base.model.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> findAll();
    void deleteSubjectByName(String subject);
    void addSubject(String subject);
}