package com.example.tads_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Kid {
    private String id;
    private String name;
    private Byte age;
    private String gender;
}
