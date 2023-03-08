package com.example.cashfile.fileController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.cashfile.Entity.file;
import com.example.cashfile.fileServices.fileServ;
import com.example.cashfile.model.ResponseData;


@RestController
public class IController {
	@Autowired
	private fileServ sev;

	public IController(fileServ sev) {
		super();
		this.sev = sev;
	}
	
	
	 @PostMapping("/upload")
	 public ResponseData uploadFile(@RequestParam("file") MultipartFile file ) throws Exception {
		 file fileupload =  null;
		 String downloadURL ="";
		 
		 
		 fileupload = sev.savefile(file);
		 
		 downloadURL= ServletUriComponentsBuilder.fromCurrentContextPath()
				 .path("/download")
				 .path(fileupload.getFfid())
				 .toUriString();
		 
		 
		 return new ResponseData(fileupload.getFileName(),downloadURL,file.getContentType(),file.getSize() ); 
		 
	 }
	 
	 @GetMapping("/download/{fileId}")
	 public ResponseEntity<org.springframework.core.io.Resource> downloadFile(@PathVariable String fileId) throws Exception{
		 file fileupload = null;
		 
		 fileupload = sev.getfile(fileId);
		 
		 return ResponseEntity.ok()
				 .contentType(MediaType.parseMediaType(fileupload.getFileType()))
				 .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "fileupload; filename=\""+ fileupload.getFileName()+"\"")
				 .body(new ByteArrayResource(fileupload.getData()));
		 
		 
		 
		 
		 
	 }

}
