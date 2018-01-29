package com.pravin.hibernate.retrieve;

import static java.lang.System.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.pravin.hibernate.entity.EmployeeEntity;
import com.pravin.hibernate.util.HibernateUtil;

/**
 * @author ppatil
 */
public class GetAllData {
    public static void main(String[] args) {
	Transaction transaction = null;
	try (SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();) {
	    transaction = session.beginTransaction();

	    /**
	     * HQL
	     */

	    /**
	     * CriteriaQuery<EmployeeEntity> criteriaQuery =
	     * session.getCriteriaBuilder() .createQuery(EmployeeEntity.class);
	     * criteriaQuery.from(EmployeeEntity.class); List<EmployeeEntity>
	     * employeeEntities = session.createQuery(criteriaQuery)
	     * .getResultList();
	     */

	    /**
	     * Native Query
	     */
	    List<EmployeeEntity> employeeEntities = session
		    .createNativeQuery("Select * from employee", EmployeeEntity.class)
		    .getResultList();

	    employeeEntities.forEach(a -> {
		out.println(a.getName());
		out.println(a.getContactNo());
		out.println(a.getEmail());
	    });

	    transaction.commit();
	} catch (Exception e) {
	    out.println("Exception :: " + e);
	    if (null != transaction) {
		transaction.rollback();
	    }
	}
    }
}
