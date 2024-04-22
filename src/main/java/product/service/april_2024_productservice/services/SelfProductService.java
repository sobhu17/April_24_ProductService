package product.service.april_2024_productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.mapper.GenericProductDtoMapper;
import product.service.april_2024_productservice.models.Product;
import product.service.april_2024_productservice.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> response = new ArrayList<>();
        for(Product product : products){
            response.add(GenericProductDtoMapper.convertProductEntityToProductResponseDTO(product));
        }

        return response;
    }

    @Override
    public GenericProductDto getProductById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return  GenericProductDtoMapper.convertProductEntityToProductResponseDTO(product.get());
    }

    @Override
    public GenericProductDto createProduct(Product product) {
        Product response = productRepository.save(product);
        return GenericProductDtoMapper.convertProductEntityToProductResponseDTO(response);
    }

    @Override
    public GenericProductDto deleteProductById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.deleteById(id);
        return GenericProductDtoMapper.convertProductEntityToProductResponseDTO(product.get());
    }

    @Override
    public GenericProductDto updateProductById(UUID id, Product product) {
        product.setId(id);
        Product response = productRepository.save(product);
        return GenericProductDtoMapper.convertProductEntityToProductResponseDTO(response);
    }

    @Override
    public int demoAPI() {
        return 0;
    }
}
