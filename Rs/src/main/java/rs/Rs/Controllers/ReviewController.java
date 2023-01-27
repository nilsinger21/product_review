package rs.Rs.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.Rs.models.Review;
import rs.Rs.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	private final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping
	public List<Review> getAllReviews() {
		return reviewService.getAllReviews();
	}

	@GetMapping("/{id}")
	public Review getReviewById(@PathVariable Long id) {
		return reviewService.getReviewById(id);
	}

	@PostMapping
	public Review addReview(@RequestBody Review review) {
		return reviewService.addReview(review);
	}

	@PutMapping("/{id}")
	public Review updateReview(@PathVariable Long id, @RequestBody Review review) {
		review.setId(id);
		return reviewService.updateReview(review);
	}

	@DeleteMapping("/{id}")
	public void deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
	}
}