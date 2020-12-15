package by.belstu.istomin.students_base.repositories;

import by.belstu.istomin.students_base.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
