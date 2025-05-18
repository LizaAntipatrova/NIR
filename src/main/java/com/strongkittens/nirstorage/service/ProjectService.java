package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.data.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
    public List<Project> getProjectsBySubstringInName(String substring){
        return projectRepository.findProjectsByNameContainingIgnoreCase(substring);
    }

    public List<Project> getProjectsBySubstringInKeyWords(String substring){
        return projectRepository.findProjectsByKeyWordsContainingIgnoreCase(substring);
    }

    public List<Project> getProjectsByTeacherId(Long teacherId){
        return projectRepository.findProjectsByTeacher_Id(teacherId);
    }



}
