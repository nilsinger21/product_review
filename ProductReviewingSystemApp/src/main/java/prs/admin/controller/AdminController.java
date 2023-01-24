package prs.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prs.product.Product;
import prs.product.service.ProductService;
import prs.review.Review;
import prs.review.service.ReviewService;
import prs.user.User;
import prs.user.service.UserService;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final ProductService productService;
    private final UserService userService;
    private final ReviewService reviewService;

    @Autowired
    public AdminController(ProductService productService, UserService userService, ReviewService reviewService) {
        this.productService = productService;
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @DeleteMapping("/review/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteById(id);
    }

    @PutMapping("/review/{id}")
    public Review updateReview(@PathVariable("id") Long id, @RequestBody Review review) {
        return reviewService.updateReview(id, review);
    }
}
