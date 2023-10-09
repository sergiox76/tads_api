package com.example.tads_api.service;
import com.example.tads_api.exceptions.KidsException;
import com.example.tads_api.model.Kid;
import com.example.tads_api.model.ListSE;
import com.example.tads_api.model.Node;
import lombok.Data;
import org.springframework.stereotype.Service;
@Data
@Service
public class ListSEService {
    private ListSE kids;

    public ListSEService() {
        kids = new ListSE();
        kids.add(new Kid("1005085752", "Valeria Osorio"
                , (byte) 20, "mujer"));
        kids.add(new Kid("356373763", "Jhair Torres"
                , (byte) 18, "hombre"));
        kids.add(new Kid("4554544554", "Sergio Núñez"
                , (byte) 19, "hombre"));
        kids.add(new Kid("28746378192", "Daniela Torrres"
                , (byte) 18, "mujer"));


    }

    //Add Pos#4
    public String addAtPosition(int pos, Kid kid) {
        kids.addAtPosition(pos, kid);
        return "Insertado";
    }

    public String invert() {
        kids.invert();
        return "Invertido";
    }

    public String changeExt() {
        kids.changeExt();
        return "Invertidos";
    }

    public String deleteByPosition(int pos) throws KidsException {
        kids.deleteByPosition(pos);
        return "Eliminado";
    }
    public String deleteId(String identification){
        kids.deleteId(identification);
        return "borrado";
    }

    public String updateInPos(byte pos, Kid kid) {
        kids.updateInPos(pos, kid);
        return "Actualizado";
    }
}


