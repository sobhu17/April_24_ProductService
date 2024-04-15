package product.service.april_2024_productservice.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import product.service.april_2024_productservice.DTOs.GenericCartDto;

import java.util.List;

@Component
public class FakeStoreCartClient {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    private String cartUrl = "https://fakestoreapi.com/carts?userId=";

    public List<GenericCartDto> getCartForUser(int id) {
        cartUrl = cartUrl + id;

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericCartDto[]> response = restTemplate.getForEntity(cartUrl , GenericCartDto[].class);
        return List.of(response.getBody());
    }
}
