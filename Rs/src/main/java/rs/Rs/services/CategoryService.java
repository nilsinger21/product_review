package rs.Rs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.Rs.models.Category;
import rs.Rs.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
