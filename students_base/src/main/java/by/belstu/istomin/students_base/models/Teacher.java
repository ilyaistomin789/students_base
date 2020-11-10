package by.belstu.istomin.students_base.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher_information")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private String firstName;
    private String lastName;
    private String middleName;
    private String department;
}
