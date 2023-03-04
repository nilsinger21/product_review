package rs.Rs.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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

	@GetMapping
	public List<Product> getAllProducts() {
		System.out.println(productService.getAll().get(0).getName());
		return  productService.getAll();
	}

	@GetMapping("/pagination")
	public List<Product> getAllByPagination(@RequestParam int page, @RequestParam int size) {
		return productService.getAllByPagination(page, size);
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		System.out.println(product);
		return productService.addProduct(product);
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}



}