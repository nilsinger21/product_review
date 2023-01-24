package prs.reviewvalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prs.profanitycheck.service.ProfanityCheck;
import prs.review.Review;
import prs.spamcheck.service.SpamCheck;

@Service
public class ReviewValidation {
    @Autowired
    private SpamCheck spamCheckService;
    @Autowired
    private ProfanityCheck profanityCheckService;

    public void validate(Review review) {
        if (spamCheckService.isSpam(review.getTitle(), review.getContent())) {
            throw new IllegalArgumentException("Review contains spam");
        }
        if (profanityCheckService.containsProfanity(review.getTitle(), review.getContent())) {
            throw new IllegalArgumentException("Review contains profanity");
        }
    }
}
