package com.example.cashfile.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data@NoArgsConstructor
public class file {
	
	
	@Id
	@GeneratedValue(generator ="uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	private String ffid;
	
	
	private String fileName;
	
	private String fileType;
	@Lob
	private byte[] data;
	public file(String fileName, String fileType, byte[] data) {
	
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
//	public String getFfid() {
//		return ffid;
//	}
//	public void setFfid(String ffid) {
//		this.ffid = ffid;
//	}
//	public String getFileName() {
//		return fileName;
//	}
//	public void setFileName(String fileName) {
//		this.fileName = fileName;
//	}
//	public String getFileType() {
//		return fileType;
//	}
//	public void setFileType(String fileType) {
//		this.fileType = fileType;
//	}
//	public byte[] getData() {
//		return data;
//	}
//	public void setData(byte[] data) {
//		this.data = data;
//	}
////	
//	

	
	

}
