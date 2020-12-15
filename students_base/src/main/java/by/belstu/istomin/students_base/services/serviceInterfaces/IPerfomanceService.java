package by.belstu.istomin.students_base.services.serviceInterfaces;

import by.belstu.istomin.students_base.dto.RateDto;
import by.belstu.istomin.students_base.model.AcademicPerformance;
import by.belstu.istomin.students_base.model.Subject;
import by.belstu.istomin.students_base.model.User;
import by.belstu.istomin.students_base.services.PerfomanceService;

import java.util.List;

public interface IPerfomanceService {
    void rate(RateDto rateDto);
    List<String> findByUser(String username);
}
