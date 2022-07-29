package com.Java_App.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Java_App.main.model.Video;

public interface VideoRepo extends JpaRepository<Video, Integer>{

}
