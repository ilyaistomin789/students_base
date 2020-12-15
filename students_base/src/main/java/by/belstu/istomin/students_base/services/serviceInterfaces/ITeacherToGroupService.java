package by.belstu.istomin.students_base.services.serviceInterfaces;

import by.belstu.istomin.students_base.dto.TeacherToGroupDto;
import by.belstu.istomin.students_base.model.TeacherToGroup;
import by.belstu.istomin.students_base.model.User;

import java.util.List;

public interface ITeacherToGroupService {
    void addRecord(TeacherToGroupDto teacherToGroupDto);
    List<User> getStudents(String facultyName, String subjectName, Integer groupValue, Integer courseValue, String username);
}
