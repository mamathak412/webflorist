package com.web.blosom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
public class Flowers implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
	private long flowerId;

	@Column  
	private String flowerName;

	@Column  
	private int noOfFlowers;

	@Column  
	private double costOfFlowers;

	@Column  
	private double discount;
	
	public long getFlowerId() {
		return flowerId;
	}

	public void setFlowerId(long flowerId) {
		this.flowerId = flowerId;
	}

	public String getFlowerName() {
		return flowerName;
	}

	public void setFlowerName(String flowerName) {
		this.flowerName = flowerName;
	}

	public int getNoOfFlowers() {
		return noOfFlowers;
	}

	public void setNoOfFlowers(int noOfFlowers) {
		this.noOfFlowers = noOfFlowers;
	}

	public double getCostOfFlowers() {
		return costOfFlowers;
	}

	public void setCostOfFlowers(double costOfFlowers) {
		this.costOfFlowers = costOfFlowers;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
