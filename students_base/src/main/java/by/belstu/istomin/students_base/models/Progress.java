package by.belstu.istomin.students_base.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "progress")
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer progressId;
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String subject;
    private Integer note;
    private Date note_day;
    private String comment;
}
