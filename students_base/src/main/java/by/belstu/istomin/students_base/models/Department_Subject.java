package by.belstu.istomin.students_base.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department_subject")
public class Department_Subject {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "departmentName")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "subjectName")
    private Subject subject;
}
