/**
 * 
 */
package com.neel.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.apache.commons.lang3.RandomStringUtils;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author Neel
 *
 */


@Entity(name="Restaurant")
public class Restaurant {
	
	@Id
	@GenericGenerator(name="feteId", strategy="com.neel.services.restIdGenerator")
	@GeneratedValue(generator="feteId")
	@Column(name="feteId")
	private String feteId;
	
	@Column(name="name")
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Cascade(value = CascadeType.SAVE_UPDATE)
	private Address address;
	
	@Column(name="contactNo")
	private long contactNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="djCharge")
	private double djCharge;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Packages> packages;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Menu> menu;
	
	@Column(name="password")
	private String password;

	public String getFeteId() {
		return feteId;
	}

	public void setFeteId(String feteId) {
		this.feteId = feteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getDjCharge() {
		return djCharge;
	}

	public void setDjCharge(double djCharge) {
		this.djCharge = djCharge;
	}

	public List<Packages> getPackages() {
		return packages;
	}

	public void setPackages(List<Packages> packages) {
		this.packages = packages;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String generatePassword() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
		String pwd = RandomStringUtils.random( 8, characters );
		return pwd;
	}
	
	
}
