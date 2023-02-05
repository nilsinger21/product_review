package rs.Rs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.Rs.models.Review;
import rs.Rs.repositories.ReviewRepository;

@Service
public class ReviewService {
	private final ReviewRepository reviewRepository;

	public ReviewService(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	public Review addReview(Review review) {
		return reviewRepository.save(review);
	}

	public void deleteReview(Long id) {
		reviewRepository.deleteById(id);
	}

	public List<Review> getAllReviews() {
		return reviewRepository.findAll();
	}

	public Review getReviewById(Long id) {
		return reviewRepository.findById(id).orElse(null);
	}

	public List<Review> getReviewsByProductId(Long productId) {
		return reviewRepository.findByProductId(productId);
	}

	public Review updateReview(Review review) {
		return reviewRepository.save(review);
	}

	public byte[] getImageByProductName(Review product) {
		Review review = ReviewRepository.findByName(product).orElseThrow(() -> new NotFoundException());
		return review.getImage();
	}

}
