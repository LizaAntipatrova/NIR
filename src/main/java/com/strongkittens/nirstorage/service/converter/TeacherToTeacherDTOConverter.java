package com.strongkittens.nirstorage.service.converter;

import com.strongkittens.nirstorage.data.entity.Teacher;
import com.strongkittens.nirstorage.dto.TeacherDTO;

public class TeacherToTeacherDTOConverter {
    public static Teacher convertNewToOld(Teacher oldTeacher, TeacherDTO newDTO){
        oldTeacher.setLastName(newDTO.getLastName());
        oldTeacher.setFirstName(newDTO.getFirstName());
        oldTeacher.setMiddleName(newDTO.getMiddleName());
        oldTeacher.setPhone(newDTO.getPhone());
        oldTeacher.setJob(newDTO.getJob());
        return oldTeacher;
    }
}
