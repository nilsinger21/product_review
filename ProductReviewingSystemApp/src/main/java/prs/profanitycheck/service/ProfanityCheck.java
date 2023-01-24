package prs.profanitycheck.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class ProfanityCheck {
    private static final List<String> profanityWords = Arrays.asList("Son of Bitch", "Bitch", "hoe");
    public boolean containsProfanity(String title, String content) {
        String review = title + " " + content;
        for (String profanityWord : profanityWords) {
            if (review.contains(profanityWord)) {
                return true;
            }
        }
        return false;
    }
}
