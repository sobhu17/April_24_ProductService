package product.service.april_2024_productservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product.service.april_2024_productservice.models.Category;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category , UUID> {

    Optional<Category> findCategoryByName(String name);
}
