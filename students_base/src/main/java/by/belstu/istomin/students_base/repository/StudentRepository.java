package by.belstu.istomin.students_base.repository;

import by.belstu.istomin.students_base.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import by.belstu.istomin.students_base.models.User;

import javax.security.auth.Subject;
import java.util.List;

@EnableJpaRepositories
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "SELECT fio_value from student_information", nativeQuery = true)
    List<User> findAllStudents();
}
