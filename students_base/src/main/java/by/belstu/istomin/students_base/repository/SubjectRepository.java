package by.belstu.istomin.students_base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import by.belstu.istomin.students_base.models.Subject;
import java.util.List;

@EnableJpaRepositories
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query(value = "SELECT subject_name FROM subject", nativeQuery = true)
    List<Subject> findAllSubjects();
}
