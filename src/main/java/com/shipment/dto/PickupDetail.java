package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class PickupDetail implements Serializable {

    private String location;
    private String otherLocation;
    private String pickupDate;
    private String readyTime;
    private String closeTime;
}
