package by.belstu.istomin.students_base.repository;

import by.belstu.istomin.students_base.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByUserId(Integer id);
    User findUserByLogin(String login);
    User findUserByLoginAndPassword(String login, String password);
}
