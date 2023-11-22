package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LineItem {
    private double length;
    private double width;
    private double height;
    private double weight;
    private String description;
    private String nmfcCode;
    private String freightClass;
    private DeclaredValue declaredValue;
}
