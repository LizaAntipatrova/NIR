package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Map<Integer, Long> gradesCount = new HashMap<>();
        for (int i = 1; i<=5; i++){
            gradesCount.put(i, projectService.getCountByGrade(i));
        }
        return gradesCount;
    }

    public List<LocalDate> getTeachersProjectsDatesOverPeriodTime(Long teacherId, LocalDate startDate, LocalDate endDate) {
        return projectService.getTeacherProjectsByPublicationDateBetweenDates(teacherId, startDate, endDate).stream()
                .map(Project::getPublicationDate)
                .toList();
    }
    public Map<Integer, Long> getTeacherProjectsGradeOverPeriodTime(Long teacherId, LocalDate startDate, LocalDate endDate) {
        Map<Integer, Long> gradesCount = new HashMap<>();
        for (int i = 1; i<=5; i++){
            gradesCount.put(i, projectService.getCountByTeacherAndGrade(teacherId, i));
        }
        return gradesCount;
    }

}
