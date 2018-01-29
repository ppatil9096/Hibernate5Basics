package com.pravin.hibernate.envers;

import java.util.List;

import static java.lang.System.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import com.pravin.hibernate.entity.EmployeeEntity;
import com.pravin.hibernate.util.HibernateUtil;

/**
 * 
 * @author ppatil
 *
 */
public class GetAllRevisions {
    public static void main(String[] args) {
	Transaction transaction = null;
	try (SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();) {
	    transaction = session.beginTransaction();

	    AuditReader auditReader = AuditReaderFactory.get(session);
	    List<Number> employeeEntities = auditReader.getRevisions(EmployeeEntity.class, 44);

	    employeeEntities.forEach(a -> {
		EmployeeEntity employeeEntity = auditReader.find(EmployeeEntity.class, 44, a.intValue());
		out.println(employeeEntity.getName());
		out.println(employeeEntity.getEmail());
		out.println(employeeEntity.getContactNo());

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
