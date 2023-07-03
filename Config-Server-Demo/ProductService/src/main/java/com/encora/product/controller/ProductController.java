package com.encora.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.encora.product.dao.service.ProductService;
import com.encora.product.dto.ProductDTO;
import com.encora.product.dto.ReviewWrapperDTO;

@RestController
@RequestMapping("/api/v1")
@RefreshScope
public class ProductController {

	
	@Value("${app.product.discount}")
	private Integer discount;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/product/{productId}/{reviewFlag}")
	public ProductDTO getProductInfo(@PathVariable("productId") Long productId, @PathVariable("reviewFlag") Boolean reveiwFlag) {
		
		if(reveiwFlag) {
			ProductDTO productDTO = productService.getProductInformationById(productId);
			Double price = productDTO.getUnitPrice();
			price = (price*discount)/100;
			productDTO.setUnitPrice(productDTO.getUnitPrice()- price);
			ReviewWrapperDTO dto = restTemplate.getForObject("http://REVEIW-SERVICE/api/v1/reviews/"+productId,ReviewWrapperDTO.class );
			productDTO.setReviewList(dto.getReveiwList());
			return productDTO;
		}else {
			ProductDTO productDTO = productService.getProductInformationById(productId);
			Double price = productDTO.getUnitPrice();
			price = (price*discount)/100;
			productDTO.setUnitPrice(productDTO.getUnitPrice()- price);
			return productDTO;
		}
	}
}
