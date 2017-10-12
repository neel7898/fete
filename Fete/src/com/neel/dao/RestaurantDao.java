package com.neel.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.neel.dto.Address;
import com.neel.dto.LoginType;
import com.neel.dto.Restaurant;

@Component
public class RestaurantDao {
	
	SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public Restaurant registerRestaurant(Restaurant restaurant, Address add) {
		Session session = factory.openSession();
		session.beginTransaction();
		restaurant.setPassword(restaurant.generatePassword());
		restaurant.setAddress(add);
		session.save(restaurant);
		session.getTransaction().commit();
		session.close();
		saveLoginType(restaurant);
		return restaurant;
	}

	private void saveLoginType(Restaurant restaurant) {
		 LoginType loginType = new LoginType(restaurant.getEmail(),restaurant.getFeteId());
		 Session session = factory.openSession();
		 session.beginTransaction();
		 session.save(loginType);
		 session.getTransaction().commit();
		 session.close();
	}

	public Address addAddress(Address add) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(add);
		session.getTransaction().commit();
		session.close();
		return add;
	}

}
