package rs.Rs.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rs.Rs.models.Product;
import rs.Rs.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/category/{category}")
	public List<Product> searchByCategory(@PathVariable String category) {
		return productService.searchByCategory(category);
	}

	@GetMapping("/pagination")
	public List<Product> getAllByPagination(@RequestParam int page, @RequestParam int size) {
		return productService.getAllByPagination(page, size);
	}

// other methods
}