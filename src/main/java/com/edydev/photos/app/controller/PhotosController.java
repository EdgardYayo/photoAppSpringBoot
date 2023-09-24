package com.edydev.photos.app.controller;

import java.io.IOException;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.edydev.photos.app.model.Photo;
import com.edydev.photos.app.service.PhotoService;


@RestController
public class PhotosController {

   
    private final PhotoService photoService;

    public PhotosController(PhotoService photoService) {
        this.photoService = photoService;
    }
    

    @GetMapping("/photos")
    public Collection<Photo> get() {
        return photoService.values();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = photoService.get(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
   }

   @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable String id) {
        Photo photo = photoService.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException{
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }


}
