package com.example.tads_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class ListSE {
    private Node head;
    private int size;

    //Add End
    public void add(Kid kid){
        // Verificamos si hay datos
        if(this.head ==null){
            //No hay datos
            this.head = new Node(kid);
        }
        else {
            //Si hay dadots, y como  yo no se quien es el último
            //debo llamar a un ayudante
            // y le digo que se posicione en la cabeza
            Node temp = this.head;
            // Le digo al ayudante que while en el brazo exista un dato
            // pasese
            while(temp.getNext()!= null){
                temp = temp.getNext();
            }
            // Mi ayudante va a estar posicionado en el último
            //Meto al niño en el costal
            //Node newNode = new Node(kid);
            // le digo al ultimo que tome con su brazo al nuevo niño
            //temp.setNext(newNode);
            temp.setNext(new Node(kid));
        }
        this.size ++;

    }

    public void addToStart(Kid kid){
        if(this.head ==null){
            //No hay datos
            this.head = new Node(kid);
        }
        else{
            Node newNode = new Node(kid);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size ++;
    }
}
