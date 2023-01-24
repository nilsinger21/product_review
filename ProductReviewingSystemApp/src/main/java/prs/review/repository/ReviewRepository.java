package prs.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import prs.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
}
