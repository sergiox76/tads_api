package com.example.tads_api.service;
import com.example.tads_api.model.City;
import com.example.tads_api.model.Kid;
import com.example.tads_api.model.ListSE;
import com.example.tads_api.model.List_DE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {
    private List_DE kids;
    public ListDEService(){


        kids = new List_DE();
        kids.addKidToEnd(new Kid("1006", "Valeria Osorio", (byte) 20, "Female", new City("17001", "Manizales")));
        kids.addKidToEnd(new Kid("1007", "Jhair Torres", (byte) 18, "Male", new City("05001", "Medellin")));
        kids.addKidToEnd(new Kid("1003", "John Jaime", (byte) 18, "Male", new City("05091", "Betania")));
        kids.addKidToEnd(new Kid("1004", "Sergio Nuñez", (byte) 19, "Male", new City("11001", "Bogota")));
        kids.addKidToEnd(new Kid("1008", "Sebastian Rugeles", (byte) 19, "Male", new City("17001", "Manizales")));

   }
}

