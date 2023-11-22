# shipmentrates-java
# Rates Endpoint Documentation

## Overview:

The Rates endpoint is a crucial component of the ShipTime. This endpoint facilitates the retrieval of shipping rates based on user input. The primary objective is to interact with the predefined shipping rate APIs and provide users with real-time shipping rate information.

## Endpoint Details:

- **Endpoint:** `/rates`
- **Method:** `POST`

## Input Parameters:

1. lineItems*	[
Collection of shipment items
LineItemModel{
description:	
Represents an item in a shipment
length*	number
Length of the package (IMPERIAL: inches/METRIC: centimetres). If a decimal number is declared, please limit the fractional part to two digits

width*	number
Width of the package (IMPERIAL: inches/METRIC: centimetres). If a decimal number is declared, please limit the fractional part to two digits

height*	number
Height of the package (IMPERIAL: inches/METRIC: centimetres). If a decimal number is declared, please limit the fractional part to two digits

weight*	number
Weight of the package (IMPERIAL: pounds/METRIC: kilograms). If a decimal number is declared, please limit the fractional part to three digits

2. **Origin Address:**
   - **Type:** JSON Object
   - **Fields:**
    	AddressModel{
description:	
Address Info
companyName*	string
minLength: 0
maxLength: 40
Company name. Maximum: 40 characters.

streetAddress*	string
minLength: 0
maxLength: 50
Street Address. Maximum: 50 characters.

streetAddress2	string
minLength: 0
maxLength: 35
Street Address Line 2. Maximum: 35 characters.

city*	string
minLength: 0
maxLength: 40
City. Maximum: 40 characters.

countryCode*	string
Country Code
state*	string
State or Province. Required for CA and US
postalCode*	string
minLength: 0
maxLength: 10
Postal Code or ZIP code. Maximum: 10 characters.

attention*	string
minLength: 2
maxLength: 40
Recipient's Name. Minimum: 2 characters. Maximum: 40 characters.

email	string
minLength: 0
maxLength: 40
Email Address. Maximum: 40 characters.

phone*	string
minLength: 10
maxLength: 15
3. **Destination Address:**
   - **Type:** JSON Object
   - **Fields:**
     	AddressModel{
description:	
Address Info
companyName*	string
minLength: 0
maxLength: 40
Company name. Maximum: 40 characters.

streetAddress*	string
minLength: 0
maxLength: 50
Street Address. Maximum: 50 characters.

streetAddress2	string
minLength: 0
maxLength: 35
Street Address Line 2. Maximum: 35 characters.

city*	string
minLength: 0
maxLength: 40
City. Maximum: 40 characters.

countryCode*	string
Country Code
state*	string
State or Province. Required for CA and US
postalCode*	string
minLength: 0
maxLength: 10
Postal Code or ZIP code. Maximum: 10 characters.

attention*	string
minLength: 2
maxLength: 40
Recipient's Name. Minimum: 2 characters. Maximum: 40 characters.

email	string
minLength: 0
maxLength: 40
Email Address. Maximum: 40 characters.

phone*	string
minLength: 10
maxLength: 15

4. **Package Type:**
   - **Type:** string
   - **Description:** Enum:
[ PACKAGE, LETTER, PAK, MY_ENVELOPE, PALLET ]

5.** unitOfMeasurement*	string
Units of measurements of package dimensions and weight: inches and pounds for IMPERIAL, and centimeters and kilograms for METRIC

Enum:
[ IMPERIAL, METRIC ]

6. **Shipping Date:**
   - **Type:** string (date format)
   - 	string($date-time)
Shipment date (Format: yyyy-MM-dd)
   - **Description:** Date when the package will be shipped.

## Output:
The endpoint outputs shipping rates based on the provided input. The response includes information such as:
- Dynamic pricing.
- Available couriers.
- Service details.

## Example Usage:

### Request:
Curl of rates API

curl --location 'https://restapi.appspaces.ca/rest/rates/' \
--header 'accept: application/json' \
--header 'Content-Type: application/json' \
--header 'Authorization: Basic bmFndmVtdWFwYWxsaUBnbWFpbC5jb206UGFzc3dvcmQxMjM=' \
--data-raw '{ "from": { "companyName": "Abcd", "streetAddress": "123Enclave", "streetAddress2": "string", "city": "Aurora", "countryCode": "CA", "state": "ON", "postalCode": "L4G0J4", "attention": "Anna", "email": "Anna@gmail.com", "phone": "778 302 7883", "instructions": "Crosscheck", "residential": true, "notify": true }, "to": { "companyName": "Ritz", "streetAddress": "1589Blvd", "streetAddress2": "string", "city": "Vancouver", "countryCode": "CA", "state": "BC", "postalCode": "V5P2G8", "attention": "Van", "email": "Vana@gmail.com", "phone": "236 889 2626", "instructions": "Rome", "residential": true, "notify": true }, "packageType": "PACKAGE", "lineItems": [ { "length": 12.34, "width": 18.26, "height": 19.32, "weight": 20.424, "declaredValue": { "currency": "CAD", "amount": 12568 }, "description": "Box", "nmfcCode": "12345", "freightClass": "string" } ], "unitOfMeasurement": "IMPERIAL", "serviceOptions": [ "APPOINTMENT" ], "shipDate": "2023-11-17T04:06:27.946Z", "insuranceType": "SHIPTIME", "customsInvoice": { "invoiceContact": { "companyName": "Abcd", "streetAddress": "321 Mable Ave", "streetAddress2": "string", "city": "Aurora", "countryCode": "CA", "state": "ON", "postalCode": "L4G0J4", "attention": "Main", "email": "Main@gmail.com", "phone": "672 123 4567", "instructions": "Road", "residential": true, "notify": true, "customsBroker": "Brok123", "shipperTaxId": "12345678" }, "dutiesAndTaxes": { "dutiable": true, "paidBy": "CONSIGNEE" }, "currency": "CAD", "invoiceItems": [ { "quantity": 2, "code": "123456", "description": "Box", "origin": "CA", "provinceOrState": "ON", "unitPrice": 1062, "weight": 20.424 } ], "reasonForExport": "COMMERCIAL" }}'

### Response:

```json

{
    "availableRates": [
        {
            "baseCharge": {
                "currency": "CAD",
                "amount": 3452
            },
            "surcharges": [
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 219
                    },
                    "code": "RESIDENTIAL",
                    "name": "RESIDENTIAL"
                },
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 250
                    },
                    "code": "INSURANCE",
                    "name": "Insurance"
                }
            ],
            "taxes": [
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 196
                    },
                    "code": "TAX",
                    "name": "GST"
                }
            ],
            "totalCharge": {
                "currency": "CAD",
                "amount": 4117
            },
            "totalBeforeTaxes": {
                "currency": "CAD",
                "amount": 3921
            },
            "exchangeRate": 0.0000,
            "carrierId": "14",
            "carrierName": "Canpar",
            "serviceId": "1",
            "serviceName": "Ground",
            "transitDays": 4,
            "cutoffTime": "14:30",
            "accessTimeInterval": "2:00",
            "quoteId": "71fa7a3ea5c6b546cb4973bf43a97b0c"
        },
        {
            "baseCharge": {
                "currency": "CAD",
                "amount": 3209
            },
            "surcharges": [
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 1199
                    },
                    "code": "FUEL",
                    "name": "FUEL"
                },
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 187
                    },
                    "code": "RESIDENTIAL",
                    "name": "Home Delivery"
                },
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 65
                    },
                    "code": "OTHER",
                    "name": "PKS"
                },
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 29
                    },
                    "code": "OTHER",
                    "name": "CBN"
                },
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 250
                    },
                    "code": "INSURANCE",
                    "name": "Insurance"
                }
            ],
            "taxes": [
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 247
                    },
                    "code": "TAX",
                    "name": "GST"
                }
            ],
            "totalCharge": {
                "currency": "CAD",
                "amount": 5186
            },
            "totalBeforeTaxes": {
                "currency": "CAD",
                "amount": 4939
            },
            "exchangeRate": 0.0000,
            "carrierId": "39",
            "carrierName": "Dicom",
            "serviceId": "GRD",
            "serviceName": "Ground",
            "transitDays": 6,
            "cutoffTime": "12:00",
            "accessTimeInterval": "2:00",
            "quoteId": "6c8ec5adc84252ec285d57cd4ead8a47"
        },
        {
            "baseCharge": {
                "currency": "CAD",
                "amount": 18186
            },
            "surcharges": [
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 219
                    },
                    "code": "RESIDENTIAL",
                    "name": "RESIDENTIAL"
                },
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 250
                    },
                    "code": "INSURANCE",
                    "name": "Insurance"
                }
            ],
            "taxes": [
                {
                    "price": {
                        "currency": "CAD",
                        "amount": 933
                    },
                    "code": "TAX",
                    "name": "GST"
                }
            ],
            "totalCharge": {
                "currency": "CAD",
                "amount": 19588
            },
            "totalBeforeTaxes": {
                "currency": "CAD",
                "amount": 18655
            },
            "exchangeRate": 0.0000,
            "carrierId": "14",
            "carrierName": "Canpar",
            "serviceId": "5",
            "serviceName": "Select",
            "transitDays": 2,
            "cutoffTime": "14:30",
            "accessTimeInterval": "2:00",
            "quoteId": "f6f45dec31ec5a71c8266c4d2e37774f"
        }
    ]
}

## Conclusion: 
The Rates endpoint plays a pivotal role in providing users with accurate and real-time shipping rates based on their input. This documentation serves as a guide for developers to understand the expected input parameters, endpoint details, and the structure of the output response.

