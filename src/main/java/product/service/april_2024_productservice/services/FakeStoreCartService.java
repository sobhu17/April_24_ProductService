package product.service.april_2024_productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.service.april_2024_productservice.DTOs.GenericCartDto;
import product.service.april_2024_productservice.clients.FakeStoreCartClient;
import product.service.april_2024_productservice.exceptions.GenericException;

import java.util.List;

@Service
public class FakeStoreCartService implements CartService{

    @Autowired
    private FakeStoreCartClient fakeStoreCartClient;

    @Override
    public List<GenericCartDto> getCartForUser(int id) throws GenericException{
        if(id < 1){
            throw new GenericException("Generic Exception occurs!!!");
        }

        List<GenericCartDto> cart = fakeStoreCartClient.getCartForUser(id);
        return cart;
    }
}
