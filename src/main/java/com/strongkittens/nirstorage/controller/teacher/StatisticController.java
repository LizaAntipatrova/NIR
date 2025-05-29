package com.strongkittens.nirstorage.controller.teacher;

import com.strongkittens.nirstorage.uiservice.teacher.StatisticUITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequestMapping("/teacher/statistic")
@RequiredArgsConstructor
@Controller
public class StatisticController {
    private final StatisticUITeacherService statisticUITeacherService;

    @GetMapping
    public String showStatisticForm(Model model, @RequestHeader("Cookie") String cookie) {
        return statisticUITeacherService.getStudentLoadProjectForm(model, cookie);
    }

    @PostMapping
    public String getStatistic(Model model, @RequestHeader("Cookie") String cookie, @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        return statisticUITeacherService.postStudentLoadProject(model, cookie, startDate, endDate);
    }
}
