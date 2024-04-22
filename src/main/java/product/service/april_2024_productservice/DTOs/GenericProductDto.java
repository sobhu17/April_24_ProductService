package product.service.april_2024_productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GenericProductDto {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
//    private RatingDto rating;
    private Double rating;
}
