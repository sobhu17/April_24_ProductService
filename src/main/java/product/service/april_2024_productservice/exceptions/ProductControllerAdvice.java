package product.service.april_2024_productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import product.service.april_2024_productservice.DTOs.ExceptionDto;
import product.service.april_2024_productservice.controllers.ProductController;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException pe){
        ExceptionDto exceptionDto = new ExceptionDto(pe.getMessage() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDto , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ExceptionDto> handleGenericException(GenericException ge){
        ExceptionDto exceptionDto = new ExceptionDto(ge.getMessage() , HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionDto , HttpStatus.NOT_FOUND);
    }
}
