package com.example.tads_api.model;

import com.example.tads_api.exceptions.KidsException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class ListSE {
    private Node head;
    private int size;

    public ListSE() {

    }

    //Add End
    public void add(Kid kid) {
        if (this.head == null) {
            //No hay datos
            this.head = new Node(kid);
        } else {
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node(kid));
        }
        this.size++;

    }
    //añadir al principio

    public void addToStart(Kid kid) {
        if (this.head == null) {
            //No hay datos
            this.head = new Node(kid);
        } else {
            Node newNode = new Node(kid);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }

    //añadir en posicion
    public void addAtPosition(int pos, Kid kid) {
        if (pos == 1) {
            this.addToStart(kid);
            this.size++;

        } else if (pos > this.size) {
            this.add(kid);
            this.size++;

        } else if (pos <= this.size) {
            Node temp = this.head;
            int posAct = 1;
            while (posAct < pos - 1) {
                temp = temp.getNext();
                posAct++;
            }
            Node newNode = new Node(kid);
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.size++;
        }
    }
    public void intercalateByGender() throws KidsException {
        if (this.head == null) {
            throw new KidsException("Lista vacia");
        } else if (this.head.getNext() == null) {
            throw new KidsException("Insuficientes elementos");
        } else {
            ListSE listCopy = new ListSE();
            Node temp = this.head;
            int posMale = 1;
            int posFemale = 2;
            while (temp != null) {
                if (temp.getData().getGender().equals("hombre")) {
                    listCopy.addAtPosition(posMale, temp.getData());
                    posMale = posMale + 2;
                } else if (temp.getData().getGender().equals("mujer")) {
                    listCopy.addAtPosition(posFemale, temp.getData());
                    posFemale = posFemale + 2;
                }
                temp = temp.getNext();
            }
            this.head = listCopy.getHead();
        }
    }



    //Invertir la lista
    public void invert() {
        if (this.head != null) {
            ListSE listCopy = new ListSE();
            Node temp = this.head;
            while (temp != null) {
                listCopy.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listCopy.getHead();
        }
    }

    //Invertir extremos
    public void changeExt() {
        if (size >= 2) {
            Kid kidtep = this.head.getData();
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            this.head.setData(temp.getData());
            temp.setData(kidtep);
        }
    }

    //Eliminar por Id
    public void deleteId(String identification) {
        if (this.head == null) {
            return;
        } else if (this.head.getData().getId().equals(identification)) {
            this.head = this.head.getNext();
            size--;
            return;
        }
        Node temp = this.head;
        while (temp.getNext() != null) {
            if (temp.getNext().getData().getId().equals(identification)) {

                temp.setNext(temp.getNext().getNext());
                this.size--;
                return;
            }
            temp = temp.getNext();
        }
    }

    //Eliminar por posicion
    public void deleteByPosition(int pos) throws KidsException {
        if (pos <= 0 || pos > size) {
            throw new KidsException("La posición está fuera de rango.");
        }
        if (pos == 1) {
            head = head.getNext();
        } else {
            Node temp = head;
            int contador = 1;
            while (contador < pos - 1) {
                temp = temp.getNext();
                contador++;
            }
            temp.setNext(temp.getNext().getNext());
        }
        size--;
    }

    public void updateInPos(int posicion, Kid kid) {
        if (this.head != null) {
            Node temp = this.head;
            byte currentPos = 0;
            if (posicion > this.size) {
                this.add(kid);
            }
            while (temp.getNext() != null) {
                if (currentPos == posicion) {
                    temp.setData(kid);
                }
                temp = temp.getNext();
                currentPos++;
            }
        }
    }


}
