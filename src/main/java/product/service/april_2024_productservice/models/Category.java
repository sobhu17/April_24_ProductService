package product.service.april_2024_productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel{
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> products;
}
