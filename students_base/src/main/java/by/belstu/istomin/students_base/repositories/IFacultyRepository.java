package by.belstu.istomin.students_base.repositories;

import by.belstu.istomin.students_base.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface IFacultyRepository  extends JpaRepository<Faculty, Integer>  {
    Faculty findByFaculty(String faculty);
}
