package com.example.tads_api.model;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class City {
    @NotEmpty
    private String code;
    @NotEmpty
    private String city;
}
