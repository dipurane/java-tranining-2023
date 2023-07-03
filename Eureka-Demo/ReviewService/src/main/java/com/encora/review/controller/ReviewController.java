package com.encora.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encora.review.dto.ReviewWrapperDTO;
import com.encora.review.service.ReviewService;

@RestController
@RequestMapping("/api/v1")
@RefreshScope
public class ReviewController {

	
	@Autowired
	private ReviewService reviewService;
	
	
	@GetMapping("/reviews/{productId}")
	public ReviewWrapperDTO fetchReviews(@PathVariable("productId") Long productId) {
		
		ReviewWrapperDTO dto = new ReviewWrapperDTO();
		dto.setReveiwList(reviewService.fetchReviewsByProductId(productId));
		return dto; 
	}
	
	
}
