package product.service.april_2024_productservice.mappers;

import product.service.april_2024_productservice.DTOs.CategoryResponseDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
import product.service.april_2024_productservice.models.Category;
import product.service.april_2024_productservice.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static CategoryResponseDto convertCategoryToCategoryResponseDto(Category category){
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setId(category.getId());
        categoryResponseDto.setName(category.getName());
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for(Product product : category.getProducts()){
            productResponseDtos.add(ProductMapper.convertProductToProductResponseDto(product));
        }
        categoryResponseDto.setProducts(productResponseDtos);
        return categoryResponseDto;
    }
}
