package com.charynepesov.studentservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Program {
    private int id;
    private String title;
    private String coordinatorId;
    private double minCGPAForGraduation;
    private int minCreditForGraduation;
    private List<Course> courseList;
}
