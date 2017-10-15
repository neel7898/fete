/**
 * 
 */
package com.neel.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Neel
 *
 */

@Entity(name="menu")
public class Menu {
	
	@Id
	@GenericGenerator(name="mId", strategy="com.neel.services.menuIdGenerator")
	@GeneratedValue(generator="mId")
	@Column(name="menuId")
	private String menuId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="item")
	private String item;
	
	@Column(name="cost")
	private double cost;
	
	@ManyToOne
	private Restaurant rest;
	
	public Restaurant getRest() {
		return rest;
	}

	public void setRest(Restaurant rest) {
		this.rest = rest;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	@ManyToOne
	private Packages packages;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
