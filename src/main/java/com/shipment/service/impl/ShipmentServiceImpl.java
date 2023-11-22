package com.shipment.service.impl;

import com.shipment.dto.ShipmentRateRequest;
import com.shipment.dto.ShipmentRateResponse;
import com.shipment.dto.ShipmentRequest;
import com.shipment.dto.ShipmentResponse;
import com.shipment.exception.ErrorMessage;
import com.shipment.exception.RestCallFailureException;
import com.shipment.service.ShipmentService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;


@Service
public class ShipmentServiceImpl implements ShipmentService {
    private static final Logger logger = LoggerFactory.getLogger(ShipmentServiceImpl.class);
    @Override
    public ShipmentRateResponse getShipmentRates(ShipmentRateRequest shipmentRateRequest) throws Exception {
        logger.debug("Entering ShipmentServiceImpl getShipmentRates");
        ShipmentRateResponse shipmentRateResponse = new ShipmentRateResponse();
        HttpHeaders headers = createHeaders("nagvemuapalli@gmail.com", "Password123");
        headers.set("accept", "application/json");
        headers.set("Content-Type", "application/json");

        HttpEntity<ShipmentRateRequest> httpEntity = new HttpEntity<ShipmentRateRequest>(shipmentRateRequest, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ShipmentRateResponse> response = restTemplate.exchange(
                "https://restapi.appspaces.ca/rest/rates",
                HttpMethod.POST, httpEntity, ShipmentRateResponse.class);

        if (response == null) {
            logger.debug("Shipment Rate API response is null");
            throw new Exception("Shipment Rate API response is null");
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            logger.debug("Shipment Rate API is Success response body {}", response.getBody());
            shipmentRateResponse = response.getBody();
        } else {
            logger.debug("Shipment Rate API is Failed");
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage("Shipment Rate API is Failed");
            errorMessage.setStatusCode(response.getStatusCode().value());
            throw new RestCallFailureException(errorMessage, "Shipment Rate API is Failed");
        }

        logger.debug("Exiting ShipmentServiceImpl getShipmentRates");
        return shipmentRateResponse;
    }

    @Override
    public ShipmentResponse saveShipments(ShipmentRequest shipmentRequest)  throws Exception {
        logger.debug("Entering ShipmentServiceImpl saveShipments");
        ShipmentResponse shipmentDetails = new ShipmentResponse();
        HttpHeaders headers = createHeaders("nagvemuapalli@gmail.com", "Password123");
        headers.set("accept", "application/json");
        headers.set("Content-Type", "application/json");

        HttpEntity<ShipmentRequest> httpEntity = new HttpEntity<ShipmentRequest>(shipmentRequest, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ShipmentResponse> response = restTemplate.exchange(
                "https://restapi.appspaces.ca/rest/shipments",
                HttpMethod.POST, httpEntity, ShipmentResponse.class);

        if (response == null) {
            logger.debug("Shipment API response is null");
            throw new Exception("Shipment API response is null");
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            logger.debug("Shipment API is Success response body {}", response.getBody());
            shipmentDetails = response.getBody();
        } else {
            logger.debug("Shipment API is Failed");
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage("Shipment API is Failed");
            errorMessage.setStatusCode(response.getStatusCode().value());
            throw new RestCallFailureException(errorMessage, "Shipment API is Failed");
        }

        logger.debug("Exiting ShipmentServiceImpl saveShipments");
        return shipmentDetails;
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}
