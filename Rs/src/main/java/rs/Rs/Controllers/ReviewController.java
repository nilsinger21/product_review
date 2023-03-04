package rs.Rs.Controllers;

import java.util.List;


import org.springframework.web.bind.annotation.*;

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

        System.out.println("*******");
        return reviewService.getAllReviews();
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id);
    }

    @DeleteMapping("/{id}")
    public void DeleteReview(@PathVariable Long id) {
         reviewService.deleteReview(id);
    }

}
