package com.Java_App.main.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
			if(!fileName.contains(".mp4") && !fileName.contains(".mp3")) {
				throw new Exception("Only mp3 and mp4 file allowed!");
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
		
		LocalDateTime localDate = LocalDateTime.now();//For reference
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		String formattedString = localDate.format(formatter);
		
		String filebasename = "ouput_" + formattedString + ".mp4";
		
		String editedFileName = "\"D:/Spring Workspace/Java_App/upload-dir/" + filebasename +".mp4\"";
		Runtime rt = Runtime.getRuntime();
		audioFileName = "\"D:/Spring Workspace/Java_App/upload-dir/" + audioFileName + "\"";
		videoFileName = "\"D:/Spring Workspace/Java_App/upload-dir/" + videoFileName + "\"";
		
		
		String cmd = "cmd.exe /c start " + "C:/PATH_Programs/ffmpeg.exe -i "  + videoFileName + " -i " + audioFileName +" -vcodec copy -acodec copy -map 0:0 -map 1:0 " + editedFileName;
		System.out.println(cmd);
		rt.exec(cmd);
		
	}

}
