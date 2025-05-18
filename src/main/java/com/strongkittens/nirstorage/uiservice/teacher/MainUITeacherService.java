package com.strongkittens.nirstorage.uiservice.teacher;

import com.strongkittens.nirstorage.service.ProjectCatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class MainUITeacherService {
    private final ProjectCatalogService projectCatalogService;


    public String getMainTeacherForm(Model model) {
        //model.addAttribute()
        return "";
    }
}
