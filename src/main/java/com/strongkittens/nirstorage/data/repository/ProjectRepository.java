package com.strongkittens.nirstorage.data.repository;

import com.strongkittens.nirstorage.data.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    List<Project> findProjectsByNameContainingIgnoreCase(String substring);
    List<Project> findProjectsByKeyWordsContainingIgnoreCase(String substring);
    List<Project> findProjectsByTeacher_Id(Long teacherId);

    Project findProjectById(long projectId);
}
