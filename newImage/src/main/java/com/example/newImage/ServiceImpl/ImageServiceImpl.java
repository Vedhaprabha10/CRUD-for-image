package com.example.newImage.ServiceImpl;

import com.example.newImage.DTO.ImageDTO;
import com.example.newImage.Entity.ImageEntity;
import com.example.newImage.Repository.ImageRepository;
import com.example.newImage.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepo;

    @Override
    public ImageEntity saveImage(ImageDTO imageDTO) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setId(imageDTO.getId());
        imageEntity.setName(imageDTO.getName());
        imageEntity.setImage(imageDTO.getImage());
        imageEntity.setDescription(imageDTO.getDescription());
        return imageRepo.save(imageEntity) ;
    }

    @Override
    public java.util.List<ImageEntity> getAll(ImageDTO imageDTO) {
    return imageRepo.findAll();
    }

    @Override
    public void delete(Integer id){
    imageRepo.deleteById(id);
    }

    @Override
    public ImageEntity updateById(Integer id ,ImageDTO imageDTO) {
        ImageEntity image = imageRepo.findById(id).get();
        image.setName(imageDTO.getName());
        image.setImage(imageDTO.getImage());
        image.setDescription(imageDTO.getDescription());
        ImageEntity update =imageRepo.save(image);
        return update;
    }
    @Override
    public Optional<ImageEntity> getById(Integer id){
      Optional<ImageEntity> images  = imageRepo.findById(id);
      return images;
      }

}
