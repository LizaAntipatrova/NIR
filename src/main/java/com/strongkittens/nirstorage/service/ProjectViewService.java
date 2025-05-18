package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.converter.ProjectToProjectDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProjectViewService {

    private final ProjectService projectService;

    public ProjectDTO getProjectDTO(Long id){
        Project foundProject = projectService.getProjectById(id);

        return ProjectToProjectDTOConverter.convertProjectToProjectDTO(foundProject);
    }

    // дата публикации проставляю я , руководитель - id, список участников


}
