package by.belstu.istomin.students_base.service;

import by.belstu.istomin.students_base.components.Component;
import by.belstu.istomin.students_base.models.User;
import by.belstu.istomin.students_base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UserRepository userRepository;

    public User getUserById(Integer id){
        return userRepository.findUserByUserId(id);
    }
    public User getUserByLogin(String login){
        return userRepository.findUserByLogin(login);
    }
    public User getUserByLoginAndPassword(String login, String password){
        return userRepository.findUserByLoginAndPassword(login,password);
    }
    public boolean existsByLogin(String login){
        return userRepository.existsByLogin(login);
    }
    public boolean saveStudent(User user){
        if (userRepository.existsByLogin(user.getLogin())){
            return false;
        }
        else{
            user.setRole(Component.STUDENT_ROLE);
            userRepository.save(user);
            return true;
        }
    }
    public boolean saveTeacher(User user){
        if (userRepository.existsByLogin(user.getLogin())){
            return false;
        }
        else{
            user.setRole(Component.TEACHER_ROLE);
            userRepository.save(user);
            return true;
        }
    }
    public int findMaxId(){
        return userRepository.findMaxId();
    }
}
