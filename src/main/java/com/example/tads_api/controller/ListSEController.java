package com.example.tads_api.controller;

import com.example.tads_api.controller.dto.ResponseDTO;
import com.example.tads_api.exceptions.KidsException;
import com.example.tads_api.model.Kid;
import com.example.tads_api.model.ListSE;
import com.example.tads_api.model.Node;
import com.example.tads_api.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path="/listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;
//obtener la lista
    @GetMapping
    public ResponseEntity<Node> getAll() {
        return new ResponseEntity<Node>(
                listSEService.getKids().getHead(), HttpStatus.OK);
    }
//añadir al final
    @PostMapping(path = "/toend")
    public ResponseEntity<String> add(@RequestBody Kid kid) {
        // irian las validaciones de la entrada
        listSEService.getKids().add(kid);
        return new ResponseEntity<String>(
                "Adicionado exitosamente", HttpStatus.OK);
    }
//añadir al inicio
    @PostMapping(path = "/tostart")
    public ResponseEntity<String> addToStart(@RequestBody Kid kid) {
        // irian las validaciones de la entrada
        listSEService.getKids().addToStart(kid);
        return new ResponseEntity<String>(
                "Adicionado exitosamente", HttpStatus.OK);
    }

    //añadir en posicion
    @PostMapping(path = "/addAtPosition/{position}")
    public ResponseEntity<String> addKidAtPosition(@RequestBody Kid kid, @PathVariable int position) {
        if (position < 1) {
            return new ResponseEntity<>("Posición no válida", HttpStatus.BAD_REQUEST);
        }
        listSEService.getKids().addAtPosition(position, kid);
        return new ResponseEntity<>("Niño añadido en la posición " + position, HttpStatus.OK);
    }

    //intercalar por genero
    @GetMapping(path = "/intercalateByGender")
    public ResponseEntity<String> intercalateKidsByGender() {
        try {
            listSEService.getKids().intercalateByGender();
            return new ResponseEntity<>("Niños intercalados por género exitosamente", HttpStatus.OK);
        } catch (KidsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //inverir la lista
    @GetMapping(path = "/invertList")
    public ResponseEntity<String> invertList() {
        listSEService.getKids().invert();
        return new ResponseEntity<>("Lista invertida exitosamente", HttpStatus.OK);
    }

    //invertir extremos
    @GetMapping(path = "/changeExt")
    public ResponseEntity<String> changeExtremes() {
        listSEService.getKids().changeExt();
        return new ResponseEntity<>("Extremos invertidos exitosamente", HttpStatus.OK);
    }

    //eliminar por id
    @DeleteMapping(path="/deleteid/{identification}")
    public  ResponseEntity<String> deleteid(@PathVariable String identification) {
        // irian las validaciones de la entrada
        listSEService.getKids().deleteId(identification);
        return new ResponseEntity<String>(
                "borrado exitosamente", HttpStatus.OK);
    }

    //eliminar por posicion
    @DeleteMapping(path = "/deleteByPosition/{position}")
    public ResponseEntity<String> deleteKidByPosition(@PathVariable int position) {
        try {
            listSEService.getKids().deleteByPosition(position);
            return new ResponseEntity<>("Niño eliminado en la posición " + position, HttpStatus.OK);
        } catch (KidsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path="/updateinpos/{posicion}")
    public ResponseEntity<String> updateInPos(@PathVariable int posicion,@RequestBody Kid kid){
        listSEService.getKids().updateInPos(posicion,kid);
        return new ResponseEntity<String>(
                "actualizado exitosamente", HttpStatus.OK);
    }
}
