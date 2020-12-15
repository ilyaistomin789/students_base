package by.belstu.istomin.students_base.repositories;

import by.belstu.istomin.students_base.model.TeacherToGroup;
import by.belstu.istomin.students_base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITeacherToGroupRepository extends JpaRepository<TeacherToGroup, Long> {
    <S extends TeacherToGroup> S save(S s);
    List<TeacherToGroup> findByUser(User user);
}