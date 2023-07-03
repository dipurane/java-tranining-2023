package com.encora.product.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encora.product.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long>{

}
