package product.service.april_2024_productservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import product.service.april_2024_productservice.DTOs.GenericProductDto;

import java.util.List;
import java.util.UUID;

@Component
public class FakeStoreProductClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String productRequestBaseUrl = "https://fakestoreapi.com/products";

    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl , GenericProductDto[].class);

        return List.of(response.getBody());
    }


    public GenericProductDto getProductById(UUID id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.getForEntity(specificProductRequestUrl , GenericProductDto.class , id);
        return response.getBody();
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productRequestBaseUrl , product , GenericProductDto.class);
        return product;
    }

    public GenericProductDto deleteProductById(UUID id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenericProductDto.class);
        ResponseExtractor<ResponseEntity<GenericProductDto>> responseExtractor = restTemplate.responseEntityExtractor(GenericProductDto.class);
        ResponseEntity<GenericProductDto> response =  restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return response.getBody();
    }

    public GenericProductDto updateProductById(UUID id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<GenericProductDto> requestEntity = new HttpEntity<>(product , headers);

        ResponseEntity<GenericProductDto> response = restTemplate.exchange(
                specificProductRequestUrl,
                HttpMethod.PUT,
                requestEntity,
                GenericProductDto.class,
                id
        );

        return response.getBody();
    }

}
