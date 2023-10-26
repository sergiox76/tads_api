package com.example.tads_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class ReportDTO {
    private String gender;
    private String ageRange;
    private String city;
    private int quantityBrothers;
}
