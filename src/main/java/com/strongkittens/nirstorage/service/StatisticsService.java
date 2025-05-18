package com.strongkittens.nirstorage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    public List<LocalDate> getNumberProjectOverPeriodTime(LocalDate startDate, LocalDate endDate) {
        return null;
    }


    public List<LocalDate> getNumberTeachersProjectOverPeriodTime(Long teacherId, LocalDate startDate, LocalDate endDate) {
        return null;
    }

}
