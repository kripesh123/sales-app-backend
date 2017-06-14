package com.kripesh.salesapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sales {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long salesId;
	
	@ManyToOne
	@JsonBackReference
	private Customer customer;
	
	@ManyToMany
	private List<Item> itemLists;
	
	private int totalQuantity;
	
	private int totalPrice;
	
	private int soldPrice;
	
	@CreationTimestamp
	private Date created;

	public Long getSalesId() {
		return salesId;
	}

	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Item> getItemLists() {
		return itemLists;
	}

	public void setItemLists(List<Item> itemLists) {
		this.itemLists = itemLists;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getSoldPrice() {
		return soldPrice;
	}

	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	
}
