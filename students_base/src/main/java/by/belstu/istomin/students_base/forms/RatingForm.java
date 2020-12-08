package by.belstu.istomin.students_base.forms;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingForm {
    private String studentName;
    private int note;
    private String subject;
    private Date note_day;
    private String comment;
}
