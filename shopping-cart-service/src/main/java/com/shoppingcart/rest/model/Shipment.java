package com.shoppingcart.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shipmentId;
	private Date expectedDeliveryDate;
	private String shipmentPartnerName;

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Date getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(Date expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	public String getShipmentPartnerName() {
		return shipmentPartnerName;
	}

	public void setShipmentPartnerName(String shipmentPartnerName) {
		this.shipmentPartnerName = shipmentPartnerName;
	}

}
