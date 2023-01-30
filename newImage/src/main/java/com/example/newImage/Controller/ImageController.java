package com.example.newImage.Controller;

import com.example.newImage.DTO.ImageDTO;
import com.example.newImage.Entity.ImageEntity;
import com.example.newImage.Service.ImageService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
        ImageService imageService;
    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestBody ImageDTO imageDTO){
        ImageEntity image =imageService.saveImage(imageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(image);
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(@RequestBody ImageDTO imageDTO){
        List<ImageEntity> imageEntity = imageService.getAll(imageDTO);
        return  ResponseEntity.status(HttpStatus.FOUND).body(imageEntity);
    }

    @PostMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        imageService.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateImage(@PathVariable Integer id,@RequestBody ImageDTO imageDTO){
       ImageEntity images = imageService.updateById(id,imageDTO);
       return ResponseEntity.status(HttpStatus.FOUND).body(images);
    }

    @GetMapping("/get/{id}")
    public Optional<ImageEntity> getById(@PathVariable Integer id){
     Optional<ImageEntity> images  = imageService.getById(id);
     return images;
   }
}

