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

    public List<LocalDate> getProjectsDatesOverPeriodTime(LocalDate startDate, LocalDate endDate) {
        return projectService.getProjectsByPublicationDateBetweenDates(startDate, endDate).stream()
                .map(Project::getPublicationDate)
                .toList();
    }

    public Map<Integer, Long> getProjectsGradeOverPeriodTime(LocalDate startDate, LocalDate endDate) {
        return Arrays.stream(Grade.values())
                .map(Grade::getGradeValue)
                .collect(Collectors.toMap((x) -> x, (x) -> projectService.getCountByGrade(x, startDate, endDate)));

    }

    public List<LocalDate> getTeachersProjectsDatesOverPeriodTime(Long teacherId, LocalDate startDate, LocalDate endDate) {
        return projectService.getTeacherProjectsByPublicationDateBetweenDates(teacherId, startDate, endDate).stream()
                .map(Project::getPublicationDate)
                .toList();
    }

    public Map<Integer, Long> getTeacherProjectsGradeOverPeriodTime(Long teacherId, LocalDate startDate, LocalDate endDate) {
        return Arrays.stream(Grade.values())
                .map(Grade::getGradeValue)
                .collect(Collectors.toMap(
                        (x) -> x,
                        (x) -> projectService.getCountByTeacherAndGrade(teacherId, x, startDate, endDate)));
    }

}
