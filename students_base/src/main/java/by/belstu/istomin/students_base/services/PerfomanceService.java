package by.belstu.istomin.students_base.services;

import by.belstu.istomin.students_base.dto.RateDto;
import by.belstu.istomin.students_base.mail.MyConstants;
import by.belstu.istomin.students_base.model.AcademicPerformance;
import by.belstu.istomin.students_base.model.Status;
import by.belstu.istomin.students_base.model.Subject;
import by.belstu.istomin.students_base.model.User;
import by.belstu.istomin.students_base.repositories.IPerfomanceRepository;
import by.belstu.istomin.students_base.repositories.ISubjectRepository;
import by.belstu.istomin.students_base.repositories.IUserRepository;
import by.belstu.istomin.students_base.services.serviceInterfaces.IPerfomanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PerfomanceService implements IPerfomanceService {
    private final IPerfomanceRepository perfomanceRepository;
    private final ISubjectRepository iSubjectRepository;
    private final IUserRepository iUserRepository;
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    public PerfomanceService(IPerfomanceRepository perfomanceRepository, ISubjectRepository iSubjectRepository, IUserRepository iUserRepository) {
        this.perfomanceRepository = perfomanceRepository;
        this.iSubjectRepository = iSubjectRepository;
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void rate(RateDto rateDto) {
        AcademicPerformance academicPerformance = new AcademicPerformance();
        academicPerformance.setStatus(Status.ACTIVE);
        academicPerformance.setCreated(new Date());
        academicPerformance.setUpdated(new Date());
        academicPerformance.setDiscription(rateDto.getDescription());
        academicPerformance.setMark(rateDto.getMark());

        User user1 = iUserRepository.findByUsername(rateDto.getUsername());
        Subject subject = iSubjectRepository.findBySubject(rateDto.getSubject()).get(0);

        academicPerformance.setSubject(subject);
        academicPerformance.setUser(user1);
        perfomanceRepository.save(academicPerformance);


        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(MyConstants.TO_EMAIL);
        //message.setTo(user1.getEmail());
        message.setSubject("СДО BSTU");
        message.setText(String.format("Предмет: %s; Оценка: %d; %s",rateDto.getSubject(), rateDto.getMark(), rateDto.getDescription()));
        log.info("PerfomanceService : rate + mail sended");
        this.emailSender.send(message);
    }

    @Override
    public List<String> findByUser(String user) {
        User user1 = iUserRepository.findByUsername(user);
        var list = perfomanceRepository.findByUser(user1);
        List<String> listSubjectNames = list.stream().map(i -> i.getSubject().getSubject()).distinct().collect(Collectors.toList());
        log.info("PerfomanceService : findByUser");
        return listSubjectNames;
    }
}
