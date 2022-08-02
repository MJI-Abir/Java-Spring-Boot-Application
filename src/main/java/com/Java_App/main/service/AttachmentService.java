package com.Java_App.main.service;

import org.springframework.web.multipart.MultipartFile;

import com.Java_App.main.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getAttachment(String fileId) throws Exception;

	void editAttachment(String videoFileId, String audioFileId) throws Exception;

}
