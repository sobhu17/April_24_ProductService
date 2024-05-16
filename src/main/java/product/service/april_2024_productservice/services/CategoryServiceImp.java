package product.service.april_2024_productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.CategoryRequestDto;
import product.service.april_2024_productservice.DTOs.CategoryResponseDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
import product.service.april_2024_productservice.exceptions.CategoryNotFoundException;
import product.service.april_2024_productservice.mappers.CategoryMapper;
import product.service.april_2024_productservice.mappers.ProductMapper;
import product.service.april_2024_productservice.models.Category;
import product.service.april_2024_productservice.models.Product;
import product.service.april_2024_productservice.repositories.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
        category.setProducts(new ArrayList<>());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.convertCategoryToCategoryResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto getCategoryById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id " + id + " isn't available!!")
        );

        return CategoryMapper.convertCategoryToCategoryResponseDto(category);
    }

    @Override
    public CategoryResponseDto deleteCategoryById(UUID id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id " + id + " isn't available!!")
        );

        categoryRepository.deleteById(id);
        return CategoryMapper.convertCategoryToCategoryResponseDto(category);
    }

    @Override
    public CategoryResponseDto updateCategory(UUID id, CategoryRequestDto request) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id " + id + " isn't available!!")
        );

        category.setName(request.getName());
        categoryRepository.save(category);

        return CategoryMapper.convertCategoryToCategoryResponseDto(category);
    }

    @Override
    public List<ProductResponseDto> getProductsByCategoryName(String name) {
        Category category = categoryRepository.findCategoryByName(name).orElseThrow(
                ()-> new CategoryNotFoundException("Category with name " + name + " isn't exist!!!")
        );

        List<Product> products = category.getProducts();
        List<ProductResponseDto> response = new ArrayList<>();
        for(Product product : products){
            response.add(ProductMapper.convertProductToProductResponseDto(product));
        }

        return response;
    }
}
