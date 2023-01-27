package rs.Rs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.Rs.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // other methods
}
