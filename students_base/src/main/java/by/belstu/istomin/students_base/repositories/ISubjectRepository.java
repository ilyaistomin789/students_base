package by.belstu.istomin.students_base.repositories;

import by.belstu.istomin.students_base.model.Subject;
import by.belstu.istomin.students_base.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ISubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findBySubject(String subject);
    <S extends Subject> S save(S s);
}
