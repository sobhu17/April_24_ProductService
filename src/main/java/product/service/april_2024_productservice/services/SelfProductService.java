package product.service.april_2024_productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.DTOs.ProductRequestDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
import product.service.april_2024_productservice.exceptions.CategoryNotFoundException;
import product.service.april_2024_productservice.exceptions.ProductNotFoundException;
import product.service.april_2024_productservice.mappers.ProductMapper;
import product.service.april_2024_productservice.models.Category;
import product.service.april_2024_productservice.models.Product;
import product.service.april_2024_productservice.repositories.CategoryRepository;
import product.service.april_2024_productservice.repositories.ProductRepository;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> response = new ArrayList<>();
        for(Product product : products){
            response.add(ProductMapper.convertProductToProductResponseDto(product));
        }

        return response;
    }

    @Override
    public ProductResponseDto getProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("Product with id " + id + " isn't available!!!")
        );

        return ProductMapper.convertProductToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto createProduct(ProductRequestDto request) {
        Product product = ProductMapper.convertProductRequestDtoToProduct(request);
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id " + request.getCategoryId() + " isn't available!!")
        );

        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.convertProductToProductResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto deleteProductById(UUID id) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("Product with id " + id + " isn't available!!!")
        );

        productRepository.deleteById(id);
        return ProductMapper.convertProductToProductResponseDto(product);
    }

    @Override
    public ProductResponseDto updateProductById(UUID id, ProductRequestDto request) {
        Product product = productRepository.findById(id).orElseThrow(
                ()-> new ProductNotFoundException("Product with id " + id + " isn't available!!!")
        );

        product.setImage(request.getImage());
        product.setPrice(request.getPrice());
        product.setTitle(request.getTitle());
        product.setDescription(request.getDescription());
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category with id " + request.getCategoryId() + " isn't available!!")
        );

        product.setCategory(category);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.convertProductToProductResponseDto(savedProduct);
    }
}
