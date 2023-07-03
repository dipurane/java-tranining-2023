package com.encora.review.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encora.review.model.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long> {

	List<ReviewModel> findByProductId(Long productId);
}
