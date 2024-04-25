package product.service.april_2024_productservice.mappers;

import product.service.april_2024_productservice.DTOs.ProductRequestDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
import product.service.april_2024_productservice.models.Product;

public class ProductMapper {

    public static Product convertProductRequestDtoToProduct(ProductRequestDto productRequestDto){
        Product product = new Product();
        product.setImage(productRequestDto.getImage());
        product.setPrice(productRequestDto.getPrice());
        product.setRating(0);
        product.setTitle(productRequestDto.getTitle());
        product.setDescription(productRequestDto.getDescription());
        return product;
    }

    public static ProductResponseDto convertProductToProductResponseDto(Product product){
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setId(product.getId());
        productResponseDto.setImage(product.getImage());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setRating(product.getRating());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setCategory(product.getCategory());
        return productResponseDto;
    }
}
