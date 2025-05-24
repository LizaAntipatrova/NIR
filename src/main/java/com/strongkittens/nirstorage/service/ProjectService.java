package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.data.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectsBySubstringInName(String substring) {
        return projectRepository.findProjectsByNameContainingIgnoreCase(substring);
    }

    public List<Project> getProjectsBySubstringInKeyWords(String substring) {
        return projectRepository.findProjectsByKeyWordsContainingIgnoreCase(substring);
    }

    public List<Project> getProjectsByTeacherUserId(Long teacherId) {
        return projectRepository.findProjectsByTeacher_User_Id(teacherId);
    }

    public List<Project> getProjectsByPublicationDateBetweenDates(LocalDate startDate, LocalDate endDate) {
        return projectRepository.findProjectsByPublicationDateBetween(startDate, endDate);
    }

    public List<Project> getTeacherProjectsByPublicationDateBetweenDates(Long userId, LocalDate startDate, LocalDate endDate) {
        return projectRepository.findProjectsByTeacher_User_IdAndPublicationDateBetween(userId, startDate, endDate);
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findProjectById(projectId);
    }

    public long getCountByGrade(Integer grade, LocalDate startDate, LocalDate endDate) {
        return projectRepository.countByGradeAndPublicationDateBetween(grade, startDate, endDate);
    }

    public long getCountByTeacherAndGrade(Long userId, Integer grade, LocalDate startDate, LocalDate endDate) {
        return projectRepository.countByTeacher_User_IdAndGradeAndPublicationDateBetween(userId, grade, startDate, endDate);
    }


    public Project save(Project project) {
        return projectRepository.save(project);
    }
}
