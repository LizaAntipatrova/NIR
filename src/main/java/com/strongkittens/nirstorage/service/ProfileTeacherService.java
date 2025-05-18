package com.strongkittens.nirstorage.service;


import com.strongkittens.nirstorage.data.entity.Job;
import com.strongkittens.nirstorage.data.entity.Student;
import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileTeacherService {

    private final TeacherService teacherService;

    public TeacherDTO getTeacherDTO(Long id){
        Teacher foundTeacher = teacherService.findTeacherById(id);

        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(id);
        teacherDTO.setLastName(foundTeacher.getLastName());
        teacherDTO.setFirstName(foundTeacher.getFirstName());
        teacherDTO.setMiddleName(foundTeacher.getMiddleName());
        teacherDTO.setPhone(foundTeacher.getPhone());
        teacherDTO.setJob(foundTeacher.getJob());

        teacherDTO.setEmail(foundTeacher.getUser().getLogin());

        return teacherDTO;
    }

    public void updateTeacherProfileData(TeacherDTO teacherDTO){
        Teacher teacher = teacherService.findTeacherById(teacherDTO.getId());

        if (teacherDTO.getLastName() != null) {
            teacher.setLastName(teacherDTO.getLastName());
        }
        if (teacherDTO.getFirstName() != null) {
            teacher.setFirstName(teacherDTO.getFirstName());
        }
        if (teacherDTO.getMiddleName() != null) {
            teacher.setMiddleName(teacherDTO.getMiddleName());
        }
        if (teacherDTO.getPhone() != null) {
            teacher.setPhone(teacherDTO.getPhone());
        }
        if (teacherDTO.getJob() != null) {
            teacher.setJob(teacherDTO.getJob());
        }

        teacherService.save(teacher);
    }
}
