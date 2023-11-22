package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class DeclaredValue implements Serializable {
    private String currency;
    private int amount;
}
