package com.example.tads_api.model;

import com.example.tads_api.exceptions.KidsException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class List_DE {
    private NodeDE head;
    private int size=0  ;

    public List_DE() {

    }

    public List<Kid> getAllKids() throws KidsException {
        if (this.head == null) {
            throw new KidsException("Lista vacia");
        } else {
            List<Kid> Kids = new ArrayList<>();
            NodeDE temp = this.head;
            while (temp != null) {
                Kids.add(temp.getData());
                temp = temp.getNext();
            }
            return Kids;
        }
    }


    public void addKidToEnd(Kid newkid){
        NodeDE newNode = new NodeDE(newkid);
        if(this.head==null){
            this.head =newNode;
        } else {
            NodeDE temp = this.head;
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            newNode.setPrevious(temp);
            this.size++;
//            System.out.println("New size value: "+this.size);
        }
    }

    public void addToStart(Kid newKid){
        if(this.head==null){
            this.head = new NodeDE(newKid);
        }
        else{
            NodeDE newHead = new NodeDE(newKid);
            newHead.setNext(this.head);
            newHead.setPrevious(null);
            this.head.setPrevious(newHead);
            this.head=newHead;
            this.size++;
        }
    }

    public void insertInPos(int pos, Kid kid) {
        if (pos == 1) {
            this.addToStart(kid);

        } else if (pos > this.size) {
            this.addKidToEnd(kid);

        } else if (pos <= this.size) {
            NodeDE temp = this.head;
            int posAct = 1;
            while (posAct < pos - 1) {
                temp = temp.getNext();
                posAct++;
            }
            NodeDE newNode = new NodeDE(kid);
            temp.getNext().setPrevious(newNode);
            newNode.setNext(temp.getNext());
            newNode.setPrevious(temp);
            temp.setNext(newNode);
            this.size++;
        }
    }
    public void invertList() {
        if (this.head != null) {
            List_DE listCopy = new List_DE();
            NodeDE temp = this.head;
            while (temp != null) {
                listCopy.addToStart(temp.getData());
                temp = temp.getNext();
            }
            this.head = listCopy.getHead();
        }
    }
    public void invertEdges() {
        if (this.head != null) {
            NodeDE temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Kid lastKid = temp.getData();
            temp.setData(this.head.getData());
            this.head.setData(lastKid);
        }
    }
}
