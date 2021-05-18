package com.example.demo.photo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoRESTController {

	@Autowired
	private PhotoServices photos; 		//Dependency injection  - Singleton of PhotoServices photos
	
	@GetMapping("/photo")
	public ResponseEntity<List<Photo>> getAllPhotos(){ 
		ArrayList<Photo> result = photos.getAllPhotos();	
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/photo/{id}")	
	public ResponseEntity getPhoto(@PathVariable Long id) { 
		Optional<Photo> result = photos.getPhoto(id);
		if(result.isPresent())
			return ResponseEntity.ok(result.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/photo")
	public ResponseEntity postPhoto(@RequestBody Photo ptemp) { 
		photos.addPhoto(ptemp); 
		// Add if above fails return 500 error
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PutMapping("/photo/{id}")
	public ResponseEntity putPhoto(@RequestBody Photo ptemp, @PathVariable Long id) { 
		photos.updatePhoto(id, ptemp);  
		// Add if above fails return 500 error
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/photo/{id}")
	public ResponseEntity deletePhoto(@PathVariable Long id) { 
		photos.deletePhoto(id);  
		// Add if above fails return 500 error
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
