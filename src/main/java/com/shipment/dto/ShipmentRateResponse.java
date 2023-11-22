package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class ShipmentRateResponse implements Serializable {

    List<AvailableRate> availableRates;
}
