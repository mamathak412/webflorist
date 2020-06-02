package src.main.java.com.web.blosom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

public class FLowers implements Serializable{

	private static final long serialVersionUID = 1L;

	private long flowerId;

	private String flowerName;

	private int noOfFlowers;

	private double costOfFlowers;

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
