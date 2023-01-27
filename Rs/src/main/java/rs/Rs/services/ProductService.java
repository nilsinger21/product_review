package rs.Rs.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import rs.Rs.models.Product;
import rs.Rs.repositories.ProductRepository;


@Service
public class ProductService {
	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public List<Product> searchByCategory(String category) {
		return productRepository.findByCategory(category);
	}

	public List<Product> getAllByPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productRepository.findAll(pageable).getContent();
	}

	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
}