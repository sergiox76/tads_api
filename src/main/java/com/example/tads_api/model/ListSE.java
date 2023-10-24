package com.example.tads_api.model;

import com.example.tads_api.controller.dto.DataDTO;
import com.example.tads_api.controller.dto.GenderDTO;
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


        } else if (pos > this.size) {
            this.add(kid);

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
            int posHombre = 1;
            int posMujer = 2;
            while (temp != null) {
                if (temp.getData().getGender().equals("hombre")) {
                    listCopy.addAtPosition(posHombre, temp.getData());
                    posHombre = posHombre + 2;
                } else if (temp.getData().getGender().equals("mujer")) {
                    listCopy.addAtPosition(posMujer, temp.getData());
                    posMujer = posMujer + 2;
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
    public List<String> getCities() {
        Node temp = this.head;
        List<String> cities = new ArrayList<>();

        while (temp != null) {
            String city = temp.getData().getCityname().getCity();
            if (!cities.contains(city)) {
                cities.add(city);
            }
            temp = temp.getNext();
        }

        return cities;
    }

    public List<DataDTO> cityReport() throws KidsException{
        if(this.head==null){
            throw new KidsException("Lista vacía");
        } else {
            List<String>  cities = this.getCities();

            List<DataDTO> cityReport = new ArrayList<>();

            List<DataDTO> cities_report = new ArrayList<>();

            for(String city :cities){
                int total_city_count=0;
                int male_count=0;
                int female_count =0;
                Node temp = this.head;
                while(temp!=null){
                    if(temp.getData().getCityname().getCity().equals(city)){
                        System.out.println("------");
                        System.out.println(temp.getData());
                        System.out.println("----");
                        System.out.println(city);
                        if(temp.getData().getGender().equals("hombre")){
                            System.out.println("hombre");
                            System.out.println("---");
                            System.out.println(temp.getData());
                            System.out.println("Previous value: "+male_count);
                            System.out.println("----");
                            male_count++;
                            System.out.println("New hombre value:  "+male_count);
                        }
                        if(temp.getData().getGender().equals("mujer")){
                            System.out.println("mujer");
                            System.out.println("-----");
                            System.out.println(temp.getData());
                            System.out.println("Previous value: "+female_count);
                            System.out.println("-----");
                            female_count++;
                            System.out.println("New mujer value:  "+female_count);
                        }
                        total_city_count++;
                        System.out.println("New total count in"+city+"-----"+total_city_count);
                    }

                    temp = temp.getNext();
                }
                GenderDTO city_females = new GenderDTO("mujer",female_count);
                GenderDTO city_males = new GenderDTO("hombre",male_count);
                System.out.println(city+"mujer in the city  "+ city_females);
                System.out.println(city+"hombre in the city  "+city_males);

                List<GenderDTO> genders = new ArrayList<>();
                genders.add(city_females);
                genders.add(city_males);

                DataDTO finalCityReport = new DataDTO(city,total_city_count,genders);
                System.out.println("----");
                System.out.println(finalCityReport);

                cities_report.add(finalCityReport);
            }

            System.out.println("---");
            System.out.println(cities_report);

            return cities_report;
        }
    }

}
