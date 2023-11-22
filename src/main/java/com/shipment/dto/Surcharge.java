package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Surcharge  implements Serializable {

    private DeclaredValue price;
    private String code;
    private String name;
}
