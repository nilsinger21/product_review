package edu.fra.uas.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.fra.uas.review.model.Review;
import edu.fra.uas.review.repository.ReviewRepository;
import edu.fra.uas.user.model.User;
import edu.fra.uas.user.repository.UserRepository;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;

    public DatabaseInitializer(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create two users
        User user1 = new User("user1");
        User user2 = new User("user2");
        userRepository.save(user1);
        userRepository.save(user2);

        // Create two products, each with a review and a user
        Review review1 = new Review();
        review1.setRating(5);
        review1.setComment("This is a great product!");
        review1.setProductId(1L);
        review1.setUser(user1);
        reviewRepository.save(review1);

        Review review2 = new Review();
        review2.setRating(4);
        review2.setComment("I really like this product.");
        review2.setProductId(2L);
        review2.setUser(user2);
        reviewRepository.save(review2);
    }
}
