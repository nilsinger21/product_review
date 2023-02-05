package rs.Rs.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private Long review_id;
	@Lob
	private byte[] review_image;
	//in Controller noch hinzufügen!
	@ManyToOne
	private Product product;
	@ManyToOne
	private User user;
	private int rating;
	private String comment;
	private LocalDateTime date;

	// getters and setters
	public Long getId() {
		return review_id;
	}

	public void setId(Long id) {
		this.review_id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public byte[] getImage() {
		return review_image;
	}

	public void setImage(byte[] image) {
		this.review_image = image;
	}

}
