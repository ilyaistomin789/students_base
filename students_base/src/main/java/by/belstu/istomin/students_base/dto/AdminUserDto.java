package by.belstu.istomin.students_base.dto;

import by.belstu.istomin.students_base.model.Faculty;
import by.belstu.istomin.students_base.model.Status;
import by.belstu.istomin.students_base.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setUsername(user.getUsername());
        return adminUserDto;
    }
}
