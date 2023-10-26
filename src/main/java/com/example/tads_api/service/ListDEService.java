package com.example.tads_api.service;
import com.example.tads_api.controller.dto.ReportDTO;
import com.example.tads_api.exceptions.KidsException;
import com.example.tads_api.model.City;
import com.example.tads_api.model.Kid;
import com.example.tads_api.model.List_DE;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class ListDEService {
    private List_DE kids;

    public ListDEService() {


        kids = new List_DE();
        kids.addKidToEnd(new Kid("1001", "Valeria Osorio", (byte) 1,
                "Female", new City("17001", "Manizales"), 1));
        kids.addKidToEnd(new Kid("1002", "Jhair Torres", (byte) 4,
                "Male", new City("05001", "Medellin"), 3));
        kids.addKidToEnd(new Kid("1003", "John Jaime", (byte) 5,
                "Male", new City("05091", "Betania"), 0));
        kids.addKidToEnd(new Kid("1004", "Sergio Nuñez", (byte) 8,
                "Male", new City("11001", "Bogota"), 1));
        kids.addKidToEnd(new Kid("1005", "Sebastian Rugeles", (byte) 9,
                "Male", new City("17001", "Manizales"), 2));
        kids.addKidToEnd(new Kid("1006", "Laura Cortez", (byte) 12,
                "Female", new City("17001", "Pitalito"), 4));
        kids.addKidToEnd(new Kid("1007", "Daniela Trujillo", (byte) 13,
                "Female", new City("17001", "Manizales"), 0));
        kids.addKidToEnd(new Kid("1007", "Carlos Loaiza", (byte) 13,
                "Male", new City("17001", "Manizales"), 0));
    }

    public List<Kid> getall() throws KidsException {
        return kids.getAllKids();
    }

    public String addKidToEnd(Kid newKid) {
        kids.addKidToEnd(newKid);
        return "Adicionado";
    }

    public String addKidToStart(Kid newKid) {
        kids.addToStart(newKid);
        return "Adicionado";
    }

    public String insertInPos(int pos, Kid kid) {
        kids.insertInPos(pos, kid);
        return "Adicionado en: " + pos;
    }

    public String invertList() {
        kids.invertList();
        return "Invertida";
    }

    public String invertEdges() {
        kids.invertEdges();
        return "Invertidos";
    }

    public String intercalateByGender() {
        try {
            kids.intercalateByGender();
            return "Intercalados";
        } catch (KidsException e) {
            return e.getMessage();
        }
    }

    public String deleteById(String id) {
        try {
            kids.deleteIdDE(id);
            return "Eliminado";
        } catch (KidsException e) {
            return e.getMessage();
        }
    }

    public String deleteInPos(int pos) {
        try {
            kids.deleteInPos(pos);
            return "Eliminado";
        } catch (KidsException e) {
            return e.getMessage();
        }
    }

    public String deleteKamikaze(int pos) {
        try {
            kids.deleteKamikaze(pos);
            return "Kamikaze";
        } catch (KidsException e) {
            return e.getMessage();

        }
    }
    public List<ReportDTO> generateReportByGenderAgeCity() throws KidsException {
        try {
            return kids.generateReportByGenderAgeCity();
        } catch (KidsException e) {
            throw new KidsException(e.getMessage());
        }
    }
}