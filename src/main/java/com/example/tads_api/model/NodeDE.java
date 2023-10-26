package com.example.tads_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class NodeDE {
    private Kid data;
    private NodeDE next;
    private NodeDE previous;

    public NodeDE (Kid data){
        this.data = data;
    }

}
