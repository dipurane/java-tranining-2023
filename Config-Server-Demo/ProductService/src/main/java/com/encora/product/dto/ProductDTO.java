package com.encora.product.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {

	private Long Id;
	private String productName;
	private String productDescription;
	private Double unitPrice;
	private List<ReviewDTO> reviewList;
	
}
