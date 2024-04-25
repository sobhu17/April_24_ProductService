package product.service.april_2024_productservice.DTOs;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import product.service.april_2024_productservice.models.Category;

import java.util.UUID;

@Getter
@Setter
public class ProductRequestDto {
    private UUID id;
    private String title;
    private double price;
    private String description;
    private String image;
    private double rating;
    private UUID categoryId;
}
