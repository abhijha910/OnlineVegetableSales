package org.vegetablesales.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer feedbackId;
	private Integer rating;
	private String comments;
	@OneToOne
	private Customer customer;
	@OneToOne
	private VegetableDTO vegetable;
	public Feedback() {
		
	}
	
	public Feedback(Integer feedbackId, Integer rating, String comments,
			Customer customer, VegetableDTO vegetable) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.comments = comments;
		this.customer = customer;
		this.vegetable = vegetable;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getRating() {
		return rating;
	}
	public void setReting(Integer rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public VegetableDTO getVegetable() {
		return vegetable;
	}

	public void setVegetable(VegetableDTO vegetable) {
		this.vegetable = vegetable;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", comments=" + comments + ", customer="
				+ customer + ", vegetable=" + vegetable + "]";
	}

	
}
