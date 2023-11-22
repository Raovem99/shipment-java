package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class AvailableRate  implements Serializable {

    private DeclaredValue baseCharge;
    private List<Surcharge> surcharges;
    private List<Surcharge> taxes;
    private DeclaredValue totalCharge;
    private DeclaredValue totalBeforeTaxes;
    private double exchangeRate;
    private String carrierId;
    private String carrierName;
    private String serviceId;
    private String serviceName;
    private int transitDays;
    private String cutoffTime;
    private String accessTimeInterval;
    private String quoteId;
}
