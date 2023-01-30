package com.example.newImage.DTO;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    int id;
    String name;
    String image;
    String description;
}
