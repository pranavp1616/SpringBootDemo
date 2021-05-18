package com.example.demo.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class PhotoServices {

	@Autowired
	private PhotoRepository prepo;
	
	public ArrayList<Photo> getAllPhotos(){
		ArrayList<Photo> result = new ArrayList<Photo>();
		prepo.findAll().forEach(result::add);
	 	return result;
	}

	public Optional<Photo> getPhoto(Long id) {
		return prepo.findById(id);
	}

	public void addPhoto(Photo ptemp) {
		prepo.save(ptemp);
	}

	public void updatePhoto(Long id, Photo ptemp) {
		// to be implemented
	}
	public void deletePhoto(Long id) {
		prepo.deleteById(id);
	}


}
