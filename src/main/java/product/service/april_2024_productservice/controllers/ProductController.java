package product.service.april_2024_productservice.controllers;

import org.springframework.http.ResponseEntity;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import org.springframework.web.bind.annotation.*;
import product.service.april_2024_productservice.services.FakeStoreProductService;
import product.service.april_2024_productservice.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/products")
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public GenericProductDto getProductById(@PathVariable("id") int id){
        return productService.getProductById(id);
    }

    @PostMapping("/products")
    public GenericProductDto createProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") int id){
        return productService.deleteProductById(id);
    }

    @PutMapping("/products/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") int id , @RequestBody GenericProductDto product){
        return productService.updateProductById(id , product);
    }
}
