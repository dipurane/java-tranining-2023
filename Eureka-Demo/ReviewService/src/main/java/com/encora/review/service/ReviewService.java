package com.encora.review.service;

import java.util.List;

import com.encora.review.dto.ReviewDTO;

public interface ReviewService {

	public List<ReviewDTO> fetchReviewsByProductId(Long productId);
}
