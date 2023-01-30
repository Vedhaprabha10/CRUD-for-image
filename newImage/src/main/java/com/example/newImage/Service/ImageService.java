package com.example.newImage.Service;

import com.example.newImage.DTO.ImageDTO;
import com.example.newImage.Entity.ImageEntity;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    ImageEntity saveImage(ImageDTO imageDTO);
    List<ImageEntity> getAll(ImageDTO imageDTO);

    void delete (Integer id);

    ImageEntity updateById(Integer id,ImageDTO imageDTO);

    Optional<ImageEntity> getById(Integer id);
}
