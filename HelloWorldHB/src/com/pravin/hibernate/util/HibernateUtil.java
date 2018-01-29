package com.pravin.hibernate.util;

import static java.lang.System.*;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * @author ppatil
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    static {
	try {
	    StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure()
		    .build();
	    Metadata metadata = new MetadataSources(standardServiceRegistry).getMetadataBuilder()
		    .build();
	    SESSION_FACTORY = metadata.getSessionFactoryBuilder()
		    .build();
	} catch (Throwable e) {
	    err.println("Enitial SessionFactory creation failed" + e);
	    throw new ExceptionInInitializerError(e);
	}
    }

    public static SessionFactory getSessionFactory() {
	return SESSION_FACTORY;
    }
}
