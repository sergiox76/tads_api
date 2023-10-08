package com.example.tads_api.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class ResponseDTO {
    private int code;
    Object data;
    List<String> error;
}
