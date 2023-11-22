package com.shipment.service;

import com.shipment.dto.ShipmentRateRequest;
import com.shipment.dto.ShipmentRateResponse;
import com.shipment.dto.ShipmentRequest;
import com.shipment.dto.ShipmentResponse;

public interface ShipmentService {
    ShipmentRateResponse getShipmentRates(ShipmentRateRequest shipmentRateRequest)  throws Exception;

    ShipmentResponse saveShipments(ShipmentRequest shipmentRequest)  throws Exception;
}
