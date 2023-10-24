package com.example.tads_api.controller;

import com.example.tads_api.controller.dto.ResponseDTO;
import com.example.tads_api.exceptions.KidsException;
import com.example.tads_api.model.Kid;
import com.example.tads_api.model.Node;
import com.example.tads_api.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path= "/listDE")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;
    @GetMapping
    public ResponseEntity<ResponseDTO> getAll(){
        try {
            return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                    listDEService.getKids().getAllKids(), null),HttpStatus.OK);
        } catch (KidsException e) {
            List<String> errors = new ArrayList<>();
            errors.add(e.getMessage());
            return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                    null,errors),HttpStatus.OK);
        }
    }
    @PostMapping(path = "/addtofinal")
    public ResponseEntity<ResponseDTO> addToFinal(@RequestBody Kid kid){
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                listDEService.addKidToEnd(kid),null),HttpStatus.OK);
    }
    @PostMapping(path = "/addtostart")
    public ResponseEntity<ResponseDTO> addToStart(@RequestBody Kid kid){
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                listDEService.addKidToStart(kid),null),HttpStatus.OK);
    }
    @PostMapping(path="/insertinpos/{pos}")
    public ResponseEntity<ResponseDTO> insertInPos(@PathVariable int pos, @RequestBody Kid kid){
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                listDEService.insertInPos(pos,kid),null),HttpStatus.OK);
    }
    @GetMapping(path = "/invertlist")
    public ResponseEntity<ResponseDTO> invertList(){
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                listDEService.invertList(),null),HttpStatus.OK);
    }
    @GetMapping(path = "/invertedges")
    public ResponseEntity<ResponseDTO> invertEdges(){
        return new ResponseEntity<>(new ResponseDTO(HttpStatus.OK.value(),
                listDEService.invertEdges(),null),HttpStatus.OK);
    }
}
