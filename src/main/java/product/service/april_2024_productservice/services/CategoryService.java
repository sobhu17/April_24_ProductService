package product.service.april_2024_productservice.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import product.service.april_2024_productservice.DTOs.CategoryRequestDto;
import product.service.april_2024_productservice.DTOs.CategoryResponseDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto createCategory(CategoryRequestDto request);
    public CategoryResponseDto getCategoryById(UUID id);
    public CategoryResponseDto deleteCategoryById(UUID id);
    public CategoryResponseDto updateCategory(UUID id , CategoryRequestDto request);
    public List<ProductResponseDto> getProductsByCategoryName(String name);
}
