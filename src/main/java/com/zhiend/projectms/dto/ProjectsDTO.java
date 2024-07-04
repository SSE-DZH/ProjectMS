package com.zhiend.projectms.dto;

import com.zhiend.projectms.enums.StatusEnum;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProjectsDTO {

    private String productName;
    private String productModel;
    private String majorProject;
    private String projectLeader;
    private String physicalPicture;
    private String productAttribute;
    private LocalDate startDate;
    private LocalDate approvalDate;
    private Integer projectScore;
    private Integer workload;
    private Integer projectDuration;
    private StatusEnum currentStatus;

    // Constructors, getters, setters, and other methods as needed
}