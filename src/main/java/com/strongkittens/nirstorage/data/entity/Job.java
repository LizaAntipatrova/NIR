package com.strongkittens.nirstorage.data.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public enum Job {
    ASSISTANT,              //АССИСТЕНТ
    ASSOCIATE_PROFESSOR,    //ДОЦЕНТ
    SENIOR_LECTURER,        //СТАРШИЙ ПРЕПОДАВАТЕЛЬ
    PROFESSOR;               //ПРОФЕСОР

    private static final Map<String, String> JOB_TITLES = new LinkedHashMap<>();

    static {
        JOB_TITLES.put("ASSISTANT", "Ассистент");
        JOB_TITLES.put("ASSOCIATE_PROFESSOR", "Доцент");
        JOB_TITLES.put("SENIOR_LECTURER", "Старший преподаватель");
        JOB_TITLES.put("PROFESSOR", "Профессор");
    }

    public static Map<String, String> getJobTitles() {
        return JOB_TITLES;
    }
}
