package product.service.april_2024_productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CategoryResponseDto {
    private UUID id;
    private String name;
    private List<ProductResponseDto> products;
}
