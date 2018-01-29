package com.pravin.hibernate.storage;

import static java.lang.System.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pravin.hibernate.entity.EmployeeEntity;
import com.pravin.hibernate.util.HibernateUtil;

/**
 * 
 * @author ppatil
 *
 */
public class CreateData {
    public static void main(String[] args) {
	Transaction transaction = null;
	try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();) {

	    transaction = session.beginTransaction();

	    EmployeeEntity emp = new EmployeeEntity();
	    emp.setName("pralhad Ohra");
	    emp.setContactNo(1789465144);
	    emp.setEmail("ab@b.com");

	    session.save(emp);
	    transaction.commit();
	    out.println("Successfully inserted");
	} catch (Exception e) {
	    out.println("Exception :: " + e);
	    if (null != transaction) {
		transaction.rollback();
	    }
	}
    }
}
