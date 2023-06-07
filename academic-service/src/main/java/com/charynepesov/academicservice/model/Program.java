package com.charynepesov.academicservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Program {
    @Id
    private int id;
    private String title;
    private String coordinatorId;
    private double minCGPAForGraduation;
    private int minCreditForGraduation;
    private List<Course> courseList;
}