package product.service.april_2024_productservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.DTOs.ProductRequestDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
import product.service.april_2024_productservice.exceptions.GenericException;
import product.service.april_2024_productservice.exceptions.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public List<ProductResponseDto> getAllProducts() throws ProductNotFoundException;
    public ProductResponseDto getProductById(UUID id) throws ProductNotFoundException;
    public ProductResponseDto createProduct(ProductRequestDto request);
    public ProductResponseDto deleteProductById(UUID id);
    public ProductResponseDto updateProductById(UUID id , ProductRequestDto request);
}
