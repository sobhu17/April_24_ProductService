package product.service.april_2024_productservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.exceptions.GenericException;
import product.service.april_2024_productservice.exceptions.ProductNotFoundException;
import product.service.april_2024_productservice.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException;
    public GenericProductDto getProductById(UUID id) throws ProductNotFoundException;
    public GenericProductDto createProduct(Product product);
    public GenericProductDto deleteProductById(UUID id);
    public GenericProductDto updateProductById(UUID id , Product product);
    public int demoAPI() throws GenericException;

}
