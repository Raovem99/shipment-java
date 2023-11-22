package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ShipmentResponse implements Serializable {

    private String shipId;
    private List<String> trackingNumbers;
    private String labelUrl;
    private String carrierTrackingUrl;
    private String pickupConfirmation;
    private List<String> messages;
}
