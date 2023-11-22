package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class ShipmentRateRequest {
    private Address from;
    private Address to;
    private String packageType;
    private List<LineItem> lineItems;
    private String unitOfMeasurement;
    private List<String> serviceOptions;
    private String shipDate;
    private String insuranceType;
    private CustomsInvoice customsInvoice;

}
