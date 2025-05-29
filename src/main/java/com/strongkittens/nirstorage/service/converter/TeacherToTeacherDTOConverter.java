package com.strongkittens.nirstorage.service.converter;


import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.dto.StudentDTO;
import com.strongkittens.nirstorage.dto.TeacherDTO;

public class TeacherToTeacherDTOConverter {
    public static Teacher convertNewToOld(Teacher oldTeacher, TeacherDTO newDTO) {
        oldTeacher.setLastName(newDTO.getLastName());
        oldTeacher.setFirstName(newDTO.getFirstName());
        oldTeacher.setMiddleName(newDTO.getMiddleName());
        oldTeacher.setPhone(newDTO.getPhone());
        oldTeacher.setJob(newDTO.getJob());
        return oldTeacher;
    }
    public static TeacherDTO convertTeacherToTeacherDTO(Teacher teacher){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setId(teacher.getId());
        teacherDTO.setLastName(teacher.getLastName());
        teacherDTO.setFirstName(teacher.getFirstName());
        teacherDTO.setMiddleName(teacher.getMiddleName());
        teacherDTO.setPhone(teacher.getPhone());
        teacherDTO.setJob(teacher.getJob());
        teacherDTO.setEmail(teacher.getUser().getLogin());
        return teacherDTO;
    }
}
