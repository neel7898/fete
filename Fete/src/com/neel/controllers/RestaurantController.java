package com.neel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neel.dao.RestaurantDao;
import com.neel.dto.Address;
import com.neel.dto.Restaurant;

@Controller
public class RestaurantController {
	
	Gson gson = new Gson();
	
	@Autowired
	RestaurantDao dao;
	
	
	
	Address add = new Address();
	
	@RequestMapping(value="/restaurant/addAddress", method=RequestMethod.POST)
	public @ResponseBody String addAddress(@RequestBody String address){
		add = gson.fromJson(address, Address.class);
		add = dao.addAddress(add);
		return gson.toJson(add);
	}
	
	@RequestMapping(value="/restaurant/add", method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody String rest){
		Restaurant restaurant = gson.fromJson(rest, Restaurant.class);
		restaurant = dao.registerRestaurant(restaurant,add);
		String email = restaurant.getEmail();
		 String message = "<b>Greetings "+restaurant.getName()+"!</b><br><br>";
	        message += "Welcome to <b>Fete</b> family. Please find your login details below :<br><br><b>Unique ID:</b> "+restaurant.getFeteId()+"<br>"
	        		+ "<b>Password:</b> "+restaurant.getPassword()   		;
	        message += "<br><br><b>Thanks & Regards,<br>Team Fete<br>mailto: support@Fete.com<br>website: www.Fete.com</b>"
	        		+ "<br><br>--------------------------------------------------------------------------------------------<br>"
	        		+ "Please do not reply. This is a system generated mail.";
		// from,password,to,subject,message
		Mailer.send("lifeeditor.94@gmail.com", "7898555253",email , "Fete - Registration Successful", message);
		add = null;
		return gson.toJson(restaurant);
	}


}
