package product.service.april_2024_productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.service.april_2024_productservice.models.Product;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product , UUID> {
}
