package com.example.cashfile.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cashfile.Entity.file;

@Repository
public interface fileRepo extends JpaRepository<file, String> {
	
	
    file save(file fileupload);

	

	Optional<file> findById(String fileId);

}
