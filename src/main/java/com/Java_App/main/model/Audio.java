package com.Java_App.main.model;

import javax.persistence.Entity;

@Entity
public class Audio {
	private int id;
	private String title;

	public Audio() {
		super();
	}

	public Audio(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}