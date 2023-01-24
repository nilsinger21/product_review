package prs.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prs.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
