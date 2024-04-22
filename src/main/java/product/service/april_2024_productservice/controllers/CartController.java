package product.service.april_2024_productservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import product.service.april_2024_productservice.DTOs.GenericCartDto;
import product.service.april_2024_productservice.services.CartService;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class CartController {
    private CartService cartService;
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/cart/{userId}")
    public List<GenericCartDto> getCartForUser(@PathVariable("userId") int id){
        return cartService.getCartForUser(id);
    }

    @GetMapping("/cart/demo")
    public int cartDemo(){
        return cartService.cartDemo();
    }
}
