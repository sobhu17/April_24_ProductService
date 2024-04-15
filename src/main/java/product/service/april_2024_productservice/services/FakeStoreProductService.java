package product.service.april_2024_productservice.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.clients.FakeStoreProductClient;
import product.service.april_2024_productservice.exceptions.GenericException;
import product.service.april_2024_productservice.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private FakeStoreProductClient fakeStoreProductClient;

    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient){
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    @Override
    public List<GenericProductDto> getAllProducts() throws ProductNotFoundException{
        List<GenericProductDto> products = fakeStoreProductClient.getAllProducts();
        if(products == null){
            throw new ProductNotFoundException("The products are not available!!!");
        }
        return products;
    }

    @Override
    public GenericProductDto getProductById(int id) throws GenericException {
        GenericProductDto product = fakeStoreProductClient.getProductById(id);
        if(product == null){
            throw new GenericException("Generic Exception occurs!!!");
        }
        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        return fakeStoreProductClient.createProduct(product);
    }

    @Override
    public GenericProductDto deleteProductById(int id) {
        return fakeStoreProductClient.deleteProductById(id);
    }

    @Override
    public GenericProductDto updateProductById(int id, GenericProductDto product) {
        return fakeStoreProductClient.updateProductById(id , product);
    }
}
