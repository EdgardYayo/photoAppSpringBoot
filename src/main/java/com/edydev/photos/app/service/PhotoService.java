package com.edydev.photos.app.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.edydev.photos.app.model.Photo;


@Service
public class PhotoService {
    
     private Map<String, Photo> db = new HashMap<>() {{
        put("1", new Photo("1", "hello.jpg"));        
        put("2", new Photo("2", "goodbye.jpg"));


    }};

    public Collection<Photo> values() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String filename, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(filename);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }

    
}
