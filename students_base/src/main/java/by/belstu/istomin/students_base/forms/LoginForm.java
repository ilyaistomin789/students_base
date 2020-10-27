package by.belstu.istomin.students_base.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    private String userName;
    private String password;
}
