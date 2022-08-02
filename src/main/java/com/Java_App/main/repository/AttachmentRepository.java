package com.Java_App.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Java_App.main.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String>{

}
