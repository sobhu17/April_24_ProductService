package product.service.april_2024_productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.service.april_2024_productservice.DTOs.CategoryRequestDto;
import product.service.april_2024_productservice.DTOs.CategoryResponseDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
import product.service.april_2024_productservice.services.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> getAllCategory(){
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable("id") UUID id){
        return categoryService.getCategoryById(id);
    }


    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto request){
        return categoryService.createCategory(request);
    }

    @DeleteMapping("/{id}")
    public CategoryResponseDto deleteCategoryById(@PathVariable("id") UUID id){
        return categoryService.deleteCategoryById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto updateCategory(@PathVariable("id") UUID id , @RequestBody CategoryRequestDto request){
        return categoryService.updateCategory(id , request);
    }

    @GetMapping("/name/{categoryName}")
    public List<ProductResponseDto> getProductsByCategoryName(@PathVariable("categoryName") String name){
        return categoryService.getProductsByCategoryName(name);
    }

}
