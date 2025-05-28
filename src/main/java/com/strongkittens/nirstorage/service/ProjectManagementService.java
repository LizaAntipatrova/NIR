package com.strongkittens.nirstorage.service;

import com.strongkittens.nirstorage.data.entity.Project;
import com.strongkittens.nirstorage.dto.CreateProjectDTO;
import com.strongkittens.nirstorage.dto.ProjectDTO;
import com.strongkittens.nirstorage.service.converter.ProjectToProjectDTOConverter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProjectManagementService {

    private final ProjectService projectService;
    private final TeacherService teacherService;
    private final StudentService studentService;

    public ProjectDTO getProjectById(Long id) {
        Project foundProject = projectService.getProjectById(id);

        return ProjectToProjectDTOConverter.convertProjectToProjectDTO(foundProject);
    }

    @SneakyThrows
    public void createProject(CreateProjectDTO createProjectDTO) {
        Project project = new Project();

        project.setName(createProjectDTO.getName());
        project.setPublicationDate(LocalDate.now());
        project.setDescription(createProjectDTO.getDescription());
        project.setKeyWords(createProjectDTO.getKeyWords());
        project.setTeacher(teacherService.findTeacherById(createProjectDTO.getTeacherId()));

        project.setStudents(createProjectDTO.getAuthorsId().stream().map(studentService::findStudentByUserId).collect(Collectors.toList()));

        if (createProjectDTO.getGrade() != null) {
            project.setGrade(createProjectDTO.getGrade());
        }

        project.setFile(createProjectDTO.getFile().getBytes());

        project = projectService.save(project);
    }

    public void giveGrade(Integer grade, Long projectId){
        Project project = projectService.getProjectById(projectId);
        project.setGrade(grade);
        projectService.save(project);
    }

}
