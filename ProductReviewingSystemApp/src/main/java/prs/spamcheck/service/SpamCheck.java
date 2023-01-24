package prs.spamcheck.service;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SpamCheck {

    private static final List<String> SPAM_WORDS = Arrays.asList("spam", "viagra", "cialis", "free money", "work from home");

    public boolean isSpam(String title, String content) {
        String review = title + " " + content;
        for (String spamWord : SPAM_WORDS) {
            if (review.toLowerCase().contains(spamWord)) {
                return true;
            }
        }
        return false;
    }
}
