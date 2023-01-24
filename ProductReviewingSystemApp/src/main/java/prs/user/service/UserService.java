package prs.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import prs.user.User;
import prs.user.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user not found"));
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
        		.orElseThrow(() -> new EntityNotFoundException("Email not found"));
    }

    @Transactional
    public User updateUser(Long id, User user) {
        User existingUser = findById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
