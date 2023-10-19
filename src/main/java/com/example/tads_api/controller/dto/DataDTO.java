package com.example.tads_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DataDTO {
    private String City;
    private int quantity;
    private List<GenderDTO>genders;
}
