package com.thbs.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class house {
	@Id
	private int pid;
	private String address;
	private int bedrooms;
	private int bathrooms;
	private int size_sqft;
	private int price;
	private String ownername;
	private String ownercontactnumber;
	public house(int pid, String address, int bedrooms, int bathrooms, int size_sqft, int price, String ownername,
			String ownercontactnumber) {
		super();
		this.pid = pid;
		this.address = address;
		this.bedrooms = bedrooms;
		this.bathrooms = bathrooms;
		this.size_sqft = size_sqft;
		this.price = price;
		this.ownername = ownername;
		this.ownercontactnumber = ownercontactnumber;
	}
	public house() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBedrooms() {
		return bedrooms;
	}
	public void setBedrooms(int bedrooms) {
		this.bedrooms = bedrooms;
	}
	public int getBathrooms() {
		return bathrooms;
	}
	public void setBathrooms(int bathrooms) {
		this.bathrooms = bathrooms;
	}
	public int getSize_sqft() {
		return size_sqft;
	}
	public void setSize_sqft(int size_sqft) {
		this.size_sqft = size_sqft;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnerName(String ownername) {
		this.ownername = ownername;
	}
	public String getOwnercontactnumber() {
		return ownercontactnumber;
	}
	public void setOwnercontactnumber(String ownercontactnumber) {
		this.ownercontactnumber = ownercontactnumber;
	}
	@Override
	public String toString() {
		return "house [pid=" + pid + ", address=" + address + ", bedrooms=" + bedrooms + ", bathrooms=" + bathrooms
				+ ", size_sqft=" + size_sqft + ", price=" + price + ", ownerName=" + ownername + ", ownercontactnumber="
				+ ownercontactnumber + "]";
	}
	

}
