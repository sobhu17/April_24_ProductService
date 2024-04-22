package product.service.april_2024_productservice.mapper;

import product.service.april_2024_productservice.DTOs.GenericProductDto;
import product.service.april_2024_productservice.models.Product;

public class GenericProductDtoMapper {

    public static Product convertProductResponseDTOToProductEntityTo(GenericProductDto genericProductDto){
        Product responseDTO = new Product();
        responseDTO.setTitle(genericProductDto.getTitle());
        responseDTO.setCategory(genericProductDto.getCategory());
        responseDTO.setRating(genericProductDto.getRating());
        responseDTO.setPrice(genericProductDto.getPrice());
        responseDTO.setImage(genericProductDto.getImage());
        responseDTO.setDescription(genericProductDto.getDescription());
        return responseDTO;
    }

    public static GenericProductDto convertProductEntityToProductResponseDTO(Product product){
        GenericProductDto responseDTO = new GenericProductDto();
        responseDTO.setId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setRating(product.getRating());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setImage(product.getImage());
        responseDTO.setDescription(product.getDescription());
        return responseDTO;
    }
}
