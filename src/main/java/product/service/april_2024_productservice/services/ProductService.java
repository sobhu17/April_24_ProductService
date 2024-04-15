package product.service.april_2024_productservice.services;

import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.exceptions.GenericException;
import product.service.april_2024_productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException;
    public GenericProductDto getProductById(int id) throws GenericException;
    public GenericProductDto createProduct(GenericProductDto product);
    public GenericProductDto deleteProductById(int id);
    public GenericProductDto updateProductById(int id , GenericProductDto product);

}
