package product.service.april_2024_productservice.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;

import java.util.List;
import java.util.UUID;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto getProductById(UUID id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(UUID id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(UUID id, GenericProductDto product) {
        return null;
    }

    @Override
    public int demoAPI() {
        return 0;
    }
}
