package com.neel.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.stereotype.Component;

import com.neel.dto.LoginType;

@Component
public class LoginDao {
	
	SessionFactory factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

	public String checkLoginType(String id) {
		// TODO Auto-generated method stub
		String loginType = "NA";
		Session session = factory.openSession();
		session.beginTransaction();
		LoginType type = (LoginType) session.get(LoginType.class,id);
		loginType = type.getUserType();
		session.getTransaction().commit();
		session.close();
		return loginType;
	}

	public String getPasswordForRestID(String id) {
		String credential = "NA";
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select password from Restaurant where feteid = '"+id+"'");
		@SuppressWarnings("unchecked")
		List<String> cred = query.list();
		if(!cred.isEmpty()){
			credential = cred.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return credential;
	}

	public String getPasswordForCustID(String id) {
		String credential = "NA";
		Session session = factory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select password from fete_customer where feteid = '"+id+"'");
		@SuppressWarnings("unchecked")
		List<String> cred = query.list();
		if(!cred.isEmpty()){
			credential = cred.get(0);
		}
		session.getTransaction().commit();
		session.close();
		return credential;
	}
	

}
