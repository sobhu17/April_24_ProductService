package product.service.april_2024_productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import product.service.april_2024_productservice.DTOs.ExceptionDto;
import product.service.april_2024_productservice.controllers.CartController;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerAdvice {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionDto> handleGenericExceptionForCart(GenericException ge){
        ExceptionDto exceptionDto = new ExceptionDto(ge.getMessage() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDto , HttpStatus.NOT_FOUND);
    }
}
