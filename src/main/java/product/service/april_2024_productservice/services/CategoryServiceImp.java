package product.service.april_2024_productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.CategoryRequestDto;
import product.service.april_2024_productservice.DTOs.CategoryResponseDto;
import product.service.april_2024_productservice.mappers.CategoryMapper;
import product.service.april_2024_productservice.models.Category;
import product.service.april_2024_productservice.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDto> response = new ArrayList<>();
        for(Category category : categories){
            response.add(CategoryMapper.convertCategoryToCategoryResponseDto(category));
        }

        return response;
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto request) {
        Category category = new Category();
        category.setName(request.getName());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.convertCategoryToCategoryResponseDto(savedCategory);
    }
}
