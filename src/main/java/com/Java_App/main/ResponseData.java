package com.Java_App.main;

public class ResponseData {
	
	private String id;
	private String fileName;
	private String downloadURL;
	private String fileType;
	private long fileSize;
	
	public ResponseData() {
		super();
	}
	
	
	public ResponseData(String id, String fileName, String downloadURL, String fileType, long fileSize) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.downloadURL = downloadURL;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}
	
	public String getId() {
		return this.id;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public String getDownloadURL() {
		return downloadURL;
	}


	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}


	public String getfileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
}
