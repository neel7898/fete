package com.neel.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neel.dao.RestaurantDao;
import com.neel.dto.Address;
import com.neel.dto.Restaurant;

@Controller
@Transactional
public class RestaurantController {
	
	Gson gson = new Gson();
	
	@Autowired
	RestaurantDao dao;	
	
	private Address add;
	
	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	@RequestMapping(value="/restaurant/addAddress", method=RequestMethod.POST)
	public @ResponseBody void addAddress(@RequestBody String address){
		Address add1 = new Address();
		add1 = gson.fromJson(address, Address.class);
		setAdd(add1);
		//add = dao.addAddress(add);
	}
	
	@RequestMapping(value="/restaurant/add", method=RequestMethod.POST)
	public @ResponseBody Restaurant add(@RequestBody String rest){
		Restaurant restaurant = gson.fromJson(rest, Restaurant.class);
		getAdd().setRest(restaurant);
		restaurant.setAddress(getAdd());
		restaurant.setPassword(restaurant.generatePassword());
		restaurant = dao.registerRestaurant(restaurant);
		String email = restaurant.getEmail();
		 String message = "<b>Greetings "+restaurant.getName()+"!</b><br><br>";
	        message += "Welcome to <b>Fete</b> family. Please find your login details below :<br><br><b>Unique ID:</b> "+restaurant.getFeteId()+"<br>"
	        		+ "<b>Password:</b> "+restaurant.getPassword()   		;
	        message += "<br><br><b>Thanks & Regards,<br>Team Fete<br>mailto: support@Fete.com<br>website: www.Fete.com</b>"
	        		+ "<br><br>--------------------------------------------------------------------------------------------<br>"
	        		+ "Please do not reply. This is a system generated mail.";
		// from,password,to,subject,message
		//Mailer.send("lifeeditor.94@gmail.com", "7898555253",email , "Fete - Registration Successful", message);
		System.out.println(restaurant.getFeteId());
		restaurant.setAddress(null);
		return restaurant;
	}
	
	@RequestMapping(value="/loadAccountDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getRestaurantById(@RequestParam String id,HttpServletRequest request){
		Restaurant rest =  dao.getRestaurantById(id);
		System.out.println(rest.getFeteId());
		rest.setMenu(null);
		rest.setPackages(null);
		JSONObject returnRest = new JSONObject(rest);
		HttpSession session = request.getSession(false);
		session.setAttribute("account", rest);
		return returnRest.toString();
	}

}
