package by.belstu.istomin.students_base.service;

import by.belstu.istomin.students_base.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.belstu.istomin.students_base.models.Subject;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;
    public List<Subject> findAllSubjects(){return subjectRepository.findAllSubjects();}
}
