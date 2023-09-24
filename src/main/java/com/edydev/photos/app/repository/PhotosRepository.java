package com.edydev.photos.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.edydev.photos.app.model.Photo;

public interface PhotosRepository extends CrudRepository<Photo, Integer> {

    
}
