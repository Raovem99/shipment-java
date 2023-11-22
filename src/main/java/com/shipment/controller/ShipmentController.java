package com.shipment.controller;



import com.shipment.dto.ShipmentRateRequest;
import com.shipment.dto.ShipmentRateResponse;
import com.shipment.dto.ShipmentRequest;
import com.shipment.dto.ShipmentResponse;
import com.shipment.service.ShipmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shipment")
@Api(value = "Shipment API - to serve the endpoints to calculate Shipment rates")
@CrossOrigin(origins = "http://localhost:4200/")
public class ShipmentController {

    private static final Logger logger = LoggerFactory.getLogger(ShipmentController.class);

    @Autowired
    ShipmentService shipmentService;

    @PostMapping(value = "/rates")
    @ApiOperation(value = "Endpoint to get Shipments ",
            produces = "application/json", response = String.class, httpMethod = "POST")
    public ShipmentRateResponse getShipmentRates(@RequestBody ShipmentRateRequest shipmentRateRequest) throws Throwable {
        logger.debug("Entering ShipmentController getShipmentRates");
        ShipmentRateResponse rates = shipmentService.getShipmentRates(shipmentRateRequest);
        logger.debug("Exiting ShipmentController getShipmentRates");
        return rates;
    }

    @PostMapping(value = "/shipments")
    @ApiOperation(value = "Endpoint to save shipments ",
            produces = "application/json", response = String.class, httpMethod = "POST")
    public ShipmentResponse saveShipments(@RequestBody ShipmentRequest shipmentRequest) throws Throwable {
        logger.debug("Entering ShipmentController saveShipments");
        ShipmentResponse shipmentDetails = shipmentService.saveShipments(shipmentRequest);
        logger.debug("Exiting ShipmentController saveShipments");
        return shipmentDetails;
    }
}
