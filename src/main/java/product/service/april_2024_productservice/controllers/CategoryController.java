package product.service.april_2024_productservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import product.service.april_2024_productservice.DTOs.CategoryRequestDto;
import product.service.april_2024_productservice.DTOs.CategoryResponseDto;
import product.service.april_2024_productservice.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponseDto> getAllCategory(){
        return categoryService.getAllCategory();
    };

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CategoryRequestDto request){
        return categoryService.createCategory(request);
    };
}
