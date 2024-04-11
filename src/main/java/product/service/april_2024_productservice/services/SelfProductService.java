package product.service.april_2024_productservice.services;

import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto getProductById(int id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(int id) {
        return null;
    }

    @Override
    public GenericProductDto updateProductById(int id, GenericProductDto product) {
        return null;
    }
}
