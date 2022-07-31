package com.Java_App.main.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "audio")
public class Audio {
	@Id
	private int id;
	private String filePath;

	public Audio() {
		super();
	}

	public Audio(int id, String filePath) {
		super();
		this.id = id;
		this.filePath = filePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
