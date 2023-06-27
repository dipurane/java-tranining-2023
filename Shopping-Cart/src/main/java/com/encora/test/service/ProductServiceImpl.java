package com.encora.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.encora.test.dto.ProductDTO;
import com.encora.test.util.DBConnector;

public class ProductServiceImpl implements ProductService{

	@Override
	public List<ProductDTO> getProductList() {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		try {
		PreparedStatement ps = con.prepareStatement("select * from emp_db.Product");
		ResultSet rs = ps.executeQuery();
		ProductDTO dto;
		
		while(rs.next()) {
			dto = new ProductDTO();
			dto.setProductId(rs.getLong(1));
			dto.setProductName(rs.getString(2));
			dto.setProductDescription(rs.getString(3));
			dto.setUnitPrice(rs.getDouble(4));
			productList.add(dto);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return productList;
	
	}

}
