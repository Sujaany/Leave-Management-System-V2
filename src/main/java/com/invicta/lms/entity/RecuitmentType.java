package com.invicta.lms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecuitmentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String recuitmentType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRecuitmentType() {
		return recuitmentType;
	}
	public void setRecuitmentType(String recuitmentType) {
		this.recuitmentType = recuitmentType;
	}
	
	
}
