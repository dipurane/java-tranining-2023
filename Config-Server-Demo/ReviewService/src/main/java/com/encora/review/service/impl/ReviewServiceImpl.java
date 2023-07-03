package com.encora.review.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.review.dao.ReviewRepository;
import com.encora.review.dto.ReviewDTO;
import com.encora.review.model.ReviewModel;
import com.encora.review.service.ReviewService;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public List<ReviewDTO> fetchReviewsByProductId(Long productId) {
		List<Long> productList = new ArrayList<>(1);
		productList.add(productId);
		List<ReviewModel> reviewList = reviewRepository.findByProductId(productId);
		List<ReviewDTO> reviewDTOList = new ArrayList<>(reviewList.size());
		for (ReviewModel reviewModel : reviewList) {
			ReviewDTO dto = new ReviewDTO();
			BeanUtils.copyProperties(reviewModel, dto);
			reviewDTOList.add(dto);
		}
		return reviewDTOList;
	}

}
