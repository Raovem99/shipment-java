package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ShipmentRequest implements Serializable {

    private RateRequest rateRequest;
    private String carrierId;
    private String serviceId;
    private String quoteId;
    private PickupDetail pickupDetail;
    private String ref1;
    private String ref2;
}
