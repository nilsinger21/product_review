package prs.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import prs.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
