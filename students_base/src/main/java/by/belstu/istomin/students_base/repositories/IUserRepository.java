package by.belstu.istomin.students_base.repositories;

import by.belstu.istomin.students_base.model.Faculty;
import by.belstu.istomin.students_base.model.Role;
import by.belstu.istomin.students_base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {
    List<User> findByMiddleName(String MiddleName);
    User findByUsername(String UserName);
    User findByEmail(String UserName);
    List<User> findByUserCourseAndFacultyNameAndUserGroup(Integer userCourse, Faculty facultyName, Integer userGroup);
    <S extends User> S save(S s);
}