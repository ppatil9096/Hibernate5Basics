package com.pravin.hibernate.customrev;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 * @author ppatil
 */
@Entity
@Table(name = "REVI_INFO")
@RevisionEntity(CustomRevisionListener.class)
public class CustomRevisionEntity extends DefaultRevisionEntity {

    private static final long serialVersionUID = 1L;

}
