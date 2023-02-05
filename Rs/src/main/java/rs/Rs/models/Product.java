package rs.Rs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	private String product_name;
	private String description;
	private double price;
	private String tag;
	@Lob
	private byte[] product_image;
	//noch zu controller hinzufügen!
	@ManyToOne
	private Category category;

	// getters and setters
	public Long getId() {
		return product_id;
	}

	public void setId(Long id) {
		this.product_id = id;
	}

	public String getName() {
		return product_name;
	}

	public void setName(String name) {
		this.product_name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public byte[] getProduct_image() {
		return product_image;
	}

	public void setProduct_image(byte[] product_image) {
		this.product_image = product_image;
	}

}
