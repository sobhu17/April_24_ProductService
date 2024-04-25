package product.service.april_2024_productservice.services;

import product.service.april_2024_productservice.DTOs.CategoryRequestDto;
import product.service.april_2024_productservice.DTOs.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    public List<CategoryResponseDto> getAllCategory();
    public CategoryResponseDto createCategory(CategoryRequestDto request);
}
