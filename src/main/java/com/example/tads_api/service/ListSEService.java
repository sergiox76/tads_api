package com.example.tads_api.service;
import com.example.tads_api.model.Kid;
import com.example.tads_api.model.ListSE;
import lombok.Data;
import org.springframework.stereotype.Service;
@Data
@Service
public class ListSEService {
    private ListSE kids;
    public ListSEService() {
        kids = new ListSE();
        kids.add(new Kid("1005085752","Valeria Osorio"
                , (byte) 20,"niña"));
        kids.add(new Kid("356373763","Jhair Torres"
                , (byte) 18,"niño"));
        kids.add(new Kid("4554544554","Sergio Núñez"
                , (byte) 19,"niño"));
        kids.add(new Kid("28746378192","Daniela Torrres"
                ,(byte) 18,"niña"));

    }
}
