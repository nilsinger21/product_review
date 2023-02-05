package rs.Rs.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long category_id;
	private String category_name;
	private String description;
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	// getters and setters
	public Long getId() {
		return category_id;
	}

	public void setId(Long id) {
		this.category_id = id;
	}

	public String getName() {
		return category_name;
	}

	public void setName(String name) {
		this.category_name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
