package com.strongkittens.nirstorage.controller.teacher;

import com.strongkittens.nirstorage.uiservice.teacher.StatisticUITeacherService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/teacher/statistic")
public class StatisticController {
    private StatisticUITeacherService statisticUITeacherService;

    @GetMapping
    public String showStatisticForm(Model model, @RequestHeader("Cookie") String cookie) {
        return statisticUITeacherService.getStudentLoadProjectForm(model, cookie);
    }

    @PostMapping
    public String getStatistic(Model model, @RequestHeader("Cookie") String cookie, @ModelAttribute("startDate") LocalDate startDate, @ModelAttribute("endDate") LocalDate endDate) {
        return statisticUITeacherService.postStudentLoadProject(model, cookie, startDate, endDate);
    }
}
