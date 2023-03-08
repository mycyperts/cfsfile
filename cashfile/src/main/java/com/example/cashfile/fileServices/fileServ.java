package com.example.cashfile.fileServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.cashfile.Entity.file;
import com.example.cashfile.Repository.fileRepo;

@Service  
public class fileServ implements servsim {
	@Autowired
	private fileRepo repo;
    
	public fileServ(fileRepo repo) {
	
		this.repo = repo;
	}

	@Override
	public file savefile(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new Exception("FileName contains invaild path sqeunce ");
			}
			
			
			file fileupload = new file(fileName,file.getContentType(),file.getBytes());
			return repo.save(fileupload);
			
		}
			
		catch(Exception e){
			
			throw new Exception("Colud not save file :"+ fileName);
			
		}
		
		
	}

	@Override
	public file getfile(String fileId) throws Exception {
		// TODO Auto-generated method stub
		
		return repo
				.findById(fileId)
				.orElseThrow(()-> new Exception("file not found with id:"+fileId));
		
		
	
	}

	

}
