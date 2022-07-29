package com.Java_App.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Java_App.main.model.Audio;

public interface AudioRepo extends JpaRepository<Audio, Integer>{

}
