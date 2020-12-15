package by.belstu.istomin.students_base.services.serviceInterfaces;

import by.belstu.istomin.students_base.dto.TeacherDto;
import by.belstu.istomin.students_base.model.User;

import java.util.List;

public interface IUserService {
    User register(User user);
    List<User> getAll();
    User findByUsername(String userName);
    User findByEmail(String userName);
    User findById(Long id);
    void delete(Long id);
    List<User> getTeachers();
}
