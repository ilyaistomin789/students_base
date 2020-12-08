package by.belstu.istomin.students_base.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationForm {
    private String login;
    private String password;
    private String confirmPassword;
}
