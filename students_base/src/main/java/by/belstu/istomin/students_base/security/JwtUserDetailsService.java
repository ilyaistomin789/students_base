package by.belstu.istomin.students_base.security;

import by.belstu.istomin.students_base.model.User;
import by.belstu.istomin.students_base.repositories.IUserRepository;
import by.belstu.istomin.students_base.security.jwt.JwtUser;
import by.belstu.istomin.students_base.security.jwt.JwtUserFactory;
import by.belstu.istomin.students_base.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
