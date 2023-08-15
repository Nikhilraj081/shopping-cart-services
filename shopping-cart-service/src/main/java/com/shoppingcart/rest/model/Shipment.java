package com.shoppingcart.rest.model;

import java.util.Date;

public class Shipment {

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
