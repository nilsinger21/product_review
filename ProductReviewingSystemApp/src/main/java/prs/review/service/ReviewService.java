package prs.review.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import prs.product.service.ProductService;
import prs.review.Review;
import prs.review.repository.ReviewRepository;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductService productService;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productService = productService;
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public Review findById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (!review.isPresent()) {
            throw new EntityNotFoundException("review not found");
        }
        return review.get();
    }

    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Transactional
    public Review updateReview(Long id, Review review) {
        Review existingReview = findById(id);
        existingReview.setTitle(review.getTitle());
        existingReview.setContent(review.getContent());
        existingReview.setRating(review.getRating());
        existingReview.setProduct(review.getProduct());
        existingReview.setUser(review.getUser());
        return reviewRepository.save(existingReview);
    }

    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }
}
