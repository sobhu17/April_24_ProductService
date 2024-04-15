package product.service.april_2024_productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class GenericCartDto {
    private int id;
    private int userId;
    private String date;
    private List<ProductQuantityDTO> products;
    private int __v;
}
