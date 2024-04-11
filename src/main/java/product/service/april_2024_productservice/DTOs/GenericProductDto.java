package product.service.april_2024_productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private int id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;
}
