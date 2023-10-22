package com.example.tads_api.controller;

import com.example.tads_api.model.Node;
import com.example.tads_api.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/listDE")
public class ListDEController {
    @Autowired
    private ListDEService listaDEService;

    @GetMapping
    public ResponseEntity<Node> getAll(){
        return new ResponseEntity<Node>(
                listaDEService.getKids().getHead(), HttpStatus.OK
        );
    }
}
