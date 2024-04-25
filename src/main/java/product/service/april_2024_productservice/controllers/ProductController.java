package product.service.april_2024_productservice.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import org.springframework.web.bind.annotation.*;
import product.service.april_2024_productservice.DTOs.ProductRequestDto;
import product.service.april_2024_productservice.DTOs.ProductResponseDto;
//import product.service.april_2024_productservice.services.FakeStoreProductService;
import product.service.april_2024_productservice.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("SelfProductService") ProductService productService){
        this.productService = productService;
    }


    @GetMapping
    public List<ProductResponseDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable("id") UUID id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto request){
        return productService.createProduct(request);
    }

    @DeleteMapping("/{id}")
    public ProductResponseDto deleteProductById(@PathVariable("id") UUID id){
        return productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    public ProductResponseDto updateProductById(@PathVariable("id") UUID id , @RequestBody ProductRequestDto request){
        return productService.updateProductById(id , request);
    }
}
