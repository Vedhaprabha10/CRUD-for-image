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
    public ResponseEntity<?> upload(@RequestBody ImageDTO imageDTO ){
        try{
            imageService.saveImage(imageDTO);
            return new ResponseEntity<>(" Image is stored in Database. ",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error Creating image id " + imageDTO +".",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(@RequestBody ImageDTO imageDTO){
        List<ImageEntity> imageEntity = imageService.getAll(imageDTO);
        return  ResponseEntity.status(HttpStatus.FOUND).body(imageEntity);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id){
        try{
            imageService.delete(id);
            return new ResponseEntity<>("Image with id " + id + " Successfully deleted.",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error on deleting id " + id +" once check in DataBase.",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateImage(@PathVariable Integer id,@RequestBody ImageDTO imageDTO){
        try{
            imageService.updateById(id,imageDTO);
            return new ResponseEntity<>("Image with id " + id + " Successfully updated.",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error on updating image id",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public Optional<ImageEntity> getById(@PathVariable Integer id){
     Optional<ImageEntity> images  = imageService.getById(id);
     return images;
   }
}

