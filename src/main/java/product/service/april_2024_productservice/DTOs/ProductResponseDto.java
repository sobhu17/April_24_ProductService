package product.service.april_2024_productservice.DTOs;

import lombok.Getter;
import lombok.Setter;
import product.service.april_2024_productservice.models.Category;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDto {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private double rating;
}
