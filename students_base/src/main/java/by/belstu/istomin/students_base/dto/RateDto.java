package by.belstu.istomin.students_base.dto;

import by.belstu.istomin.students_base.model.Subject;
import by.belstu.istomin.students_base.model.User;
import lombok.Data;

@Data
public class RateDto {
    private String username;
    private String subject;
    private Integer mark;
    private String description;
}
