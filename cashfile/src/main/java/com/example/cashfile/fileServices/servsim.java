package com.example.cashfile.fileServices;

import org.springframework.web.multipart.MultipartFile;

import com.example.cashfile.Entity.file;



public interface servsim {
	
	
	file savefile(MultipartFile file) throws Exception;
	public file getfile(String fileId) throws Exception;

}
