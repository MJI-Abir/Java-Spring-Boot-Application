package com.Java_App.main.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.Java_App.main.entity.Attachment;
import com.Java_App.main.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService {

	private AttachmentRepository attachmentRepository;
	
	public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
		this.attachmentRepository = attachmentRepository;
	}

	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new Exception("Invalid File Name");
			}
			
			Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
			return attachmentRepository.save(attachment);
		}
		catch(Exception e){
			throw new Exception("Can't save file!");
		}
	}

	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		return attachmentRepository.findById(fileId).orElseThrow
				(() -> new Exception("File not found by ID :" + fileId));
	}

	@Override
	public void editAttachment(String videoFileId, String audioFileId) throws IOException {
		Optional<Attachment> audioFile = attachmentRepository.findById(audioFileId);
		Optional<Attachment> videoFile = attachmentRepository.findById(videoFileId);
		
		String audioFileName = audioFile.get().getFileName();
		String videoFileName = videoFile.get().getFileName();
		
		String editedFileName = "output.mp4";
		Runtime rt = Runtime.getRuntime();
		
		rt.exec("cmd.exe/c start" + "ffmpeg -i " + videoFileName + " -i "
		+ audioFileName +" -c:v copy -c:a aac " + editedFileName);
		
		
	}

}
