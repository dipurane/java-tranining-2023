package com.encora.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_info")
@Getter
@Setter
public class ProductModel {

	
	@Id
	private Long id;
	private String productName;
	private String productDescription;
	private Double unitPrice;
	
}


