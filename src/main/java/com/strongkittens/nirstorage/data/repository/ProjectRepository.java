package com.strongkittens.nirstorage.data.repository;

import com.strongkittens.nirstorage.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findProjectsByNameContainingIgnoreCase(String substring);

    List<Project> findProjectsByKeyWordsContainingIgnoreCase(String substring);

    List<Project> findProjectsByTeacher_Id(Long teacherId);

    List<Project> findProjectsByPublicationDateBetween(LocalDate startDate, LocalDate endDate);

    List<Project> findProjectsByTeacher_IdAndPublicationDateBetween(Long teacherId, LocalDate startDate, LocalDate endDate);

    long countByGradeAndPublicationDateBetween(Integer grade, LocalDate startDate, LocalDate endDate);


    long countByTeacher_IdAndGradeAndPublicationDateBetween(Long teacherId, Integer grade, LocalDate startDate, LocalDate endDate);

    Project findProjectById(long projectId);
}
