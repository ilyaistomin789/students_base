package by.belstu.istomin.students_base.dto;

import java.util.List;
import by.belstu.istomin.students_base.model.Subject;
import by.belstu.istomin.students_base.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeacherDto {
    private String username;
    private String firstName;
    private String lastName;
    private String middleName;

    public static TeacherDto fromUser(User user) {
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setUsername(user.getUsername());
        teacherDto.setFirstName(user.getFirstName());
        teacherDto.setLastName(user.getLastName());
        teacherDto.setMiddleName(user.getMiddleName());
        return teacherDto;
    }
}
