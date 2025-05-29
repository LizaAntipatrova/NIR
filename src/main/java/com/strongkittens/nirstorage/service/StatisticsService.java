package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final ProjectService projectService;

    public int getProjectsDatesOverPeriodTime(LocalDate startDate, LocalDate endDate) {
        return projectService.getProjectsByPublicationDateBetweenDates(startDate, endDate).size();
    }

    public Map<Integer, Long> getProjectsGradeOverPeriodTime(LocalDate startDate, LocalDate endDate) {
        return Arrays.stream(Grade.values())
                .map(Grade::getGradeValue)
                .collect(Collectors.toMap((x) -> x, (x) -> projectService.getCountByGrade(x, startDate, endDate)));

    }

    public int getTeachersProjectsDatesOverPeriodTime(Long userId, LocalDate startDate, LocalDate endDate) {
        return projectService.getTeacherProjectsByPublicationDateBetweenDates(userId, startDate, endDate).size();
    }

    public Map<Integer, Long> getTeacherProjectsGradeOverPeriodTime(Long userId, LocalDate startDate, LocalDate endDate) {
        return Arrays.stream(Grade.values())
                .map(Grade::getGradeValue)
                .collect(Collectors.toMap(
                        (x) -> x,
                        (x) -> projectService.getCountByTeacherAndGrade(userId, x, startDate, endDate)));
    }

}
