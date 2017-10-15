package com.neel.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.neel.dto.Address;
import com.neel.dto.LoginType;
import com.neel.dto.Restaurant;

@Component
public class RestaurantDao {
	
	@Autowired
	HibernateTemplate template;
	
	public Restaurant registerRestaurant(Restaurant restaurant) {
		template.save(restaurant);
		this.saveLoginType(restaurant);
		return restaurant;
	}

	private void saveLoginType(Restaurant restaurant) {
		 LoginType loginType = new LoginType(restaurant.getEmail(),restaurant.getFeteId());
		 template.save(loginType);
	}

	public Restaurant getRestaurantById(String id){
		Restaurant rest = template.get(Restaurant.class, id);
		return rest;
	}
	
	public Address getAddressByRestaurantId(Restaurant restaurant){
		Address add = template.get(Address.class, restaurant.getAddress().getAddressId());
		return add;
	}

}
