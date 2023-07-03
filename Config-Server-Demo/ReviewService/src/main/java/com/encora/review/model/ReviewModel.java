package com.encora.review.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_review")
@Getter
@Setter
public class ReviewModel {

	@Id
	private Long id;
	
	private Long productId;
	
	private Long userId;
	
	private String review;
}
