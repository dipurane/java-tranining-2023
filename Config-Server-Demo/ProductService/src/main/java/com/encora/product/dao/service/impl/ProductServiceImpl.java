package com.encora.product.dao.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encora.product.dao.ProductRepository;
import com.encora.product.dao.service.ProductService;
import com.encora.product.dto.ProductDTO;
import com.encora.product.model.ProductModel;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ProductDTO getProductInformationById(Long productId) {
		Optional<ProductModel> optionalmodel = productRepository.findById(productId);
		ProductModel model = optionalmodel.get();
		ProductDTO dto = new ProductDTO();
		BeanUtils.copyProperties(model, dto);
		
		return dto;
	}

}
