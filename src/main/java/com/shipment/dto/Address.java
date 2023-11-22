package com.shipment.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
     private String companyName;
     private String streetAddress;
     private String streetAddress2;
     private String city;
     private String countryCode;
     private String state;
     private String postalCode;
     private String attention;
     private String email;
     private String phone;
     private String instructions;
     private boolean residential;
     private boolean notify;

}
