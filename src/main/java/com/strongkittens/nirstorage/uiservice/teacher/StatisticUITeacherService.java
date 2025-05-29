package com.strongkittens.nirstorage.uiservice.teacher;

import com.strongkittens.nirstorage.auth.services.AuthService;
import com.strongkittens.nirstorage.dto.CreateProjectDTO;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.dto.TeacherDTO;
import com.strongkittens.nirstorage.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticUITeacherService {
    private StatisticsService statisticsService;
    private AuthService authService;

    public String getStudentLoadProjectForm(Model model, String cookie) {

        return "statistic";
    }

    public String postStudentLoadProject(Model model, String cookie, LocalDate startDate, LocalDate endDate) {
        Long teacherId = authService.getUserIdFromCookie(cookie);
        int countAllProject = statisticsService.getProjectsDatesOverPeriodTime(startDate, endDate);
        Map<Integer, Long> allGrades = statisticsService.getTeacherProjectsGradeOverPeriodTime(teacherId, startDate, endDate);
        int countTeacherProject = statisticsService.getTeachersProjectsDatesOverPeriodTime(teacherId, startDate, endDate);
        Map<Integer, Long> teacherGrades = statisticsService.getTeacherProjectsGradeOverPeriodTime(teacherId, startDate, endDate);
        model.addAttribute("countAllProject", countAllProject);
        model.addAttribute("allGrades", allGrades);
        model.addAttribute("countTeacherProject", countTeacherProject);
        model.addAttribute("teacherGrades", teacherGrades);
        return "redirect:/student/main";
    }
}
