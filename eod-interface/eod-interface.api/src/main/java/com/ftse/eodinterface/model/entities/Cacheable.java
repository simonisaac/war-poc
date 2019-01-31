package com.ftse.eodinterface.model.entities;

public class Cacheable {

	private String subject;
	
	private Object entity;

	public Cacheable(String subject) {
		super();
		this.subject = subject;
	}
	
	public Cacheable(String subject, Object entity) {
		this.subject = subject;
		this.entity = entity;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}
}
