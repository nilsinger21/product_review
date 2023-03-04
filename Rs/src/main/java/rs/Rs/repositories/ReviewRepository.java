package rs.Rs.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.Rs.models.Product;
import rs.Rs.models.Review;
import rs.Rs.models.User;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProduct(Product product);
    List<Review> findByUser(User user);
    List<Review> findByProductId(Long productId);
}
