package com.shoppingcart.rest.shoppingcartservice.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int shipmentId;

    @NotEmpty(message = "expected delivery date should not be empty")
    private String expectedDeliveryDate;

    @NotEmpty(message = "shipment partner should not be empty")
    private String shipmentPartner;

    public Shipment(int shipmentId, String expectedDeliveryDate, String shipmentPartner) {
        this.shipmentId = shipmentId;
        this.expectedDeliveryDate = expectedDeliveryDate;
        this.shipmentPartner = shipmentPartner;
    }

    public Shipment() {
    }

    public int getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(int shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getExpectedDeliveryDate() {
        return expectedDeliveryDate;
    }

    public void setExpectedDeliveryDate(String expectedDeliveryDate) {
        this.expectedDeliveryDate = expectedDeliveryDate;
    }

    public String getShipmentPartner() {
        return shipmentPartner;
    }

    public void setShipmentPartner(String shipmentPartner) {
        this.shipmentPartner = shipmentPartner;
    }

    

    

}
