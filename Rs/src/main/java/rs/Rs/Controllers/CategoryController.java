package rs.Rs.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.Rs.models.Category;
import rs.Rs.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService categoryService;

	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping //checked
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}


	@GetMapping("/{name}") //checked
	public Category getCategory(@PathVariable String name) {
		System.out.println(name);
		return categoryService.getCategory(name);
	}


	@PostMapping //checked
	public Category addCategory(@RequestBody Category category) {

		return categoryService.addCategory(category);
	}

	@PutMapping("/{id}") //checked
	public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
		category.setId(id);
		return categoryService.updateCategory(category);
	}

	@DeleteMapping("/{id}") //checked
	public String deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
       return "Deleted Successfully";
	}
}