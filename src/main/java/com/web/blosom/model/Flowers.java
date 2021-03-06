package com.web.blosom.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="FLOWERS")
public class Flowers implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue
	private long flowerId;

	@Column(name="flowerName") 
	private String flowerName;

	@Column(name="noOfFlowers")   
	private int noOfFlowers;

	@Column(name="costOfFlowers")   
	private double costOfFlowers;

	@Column(name="discount") 
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
