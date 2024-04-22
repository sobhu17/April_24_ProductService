package product.service.april_2024_productservice.services;

import org.springframework.web.bind.annotation.PathVariable;
import product.service.april_2024_productservice.DTOs.GenericCartDto;
import product.service.april_2024_productservice.exceptions.GenericException;

import java.util.List;

public interface CartService {

    public List<GenericCartDto> getCartForUser(int id) throws GenericException;
    public int cartDemo() throws GenericException;
}
