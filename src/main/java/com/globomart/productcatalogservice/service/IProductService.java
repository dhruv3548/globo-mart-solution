package com.globomart.productcatalogservice.service;

import java.util.List;

import com.globomart.productcatalogservice.dto.ProductDto;

public interface IProductService {
	void addProduct(ProductDto productVo);

	List<ProductDto> getProducts();

	void deleteProduct(Long id);

	List<ProductDto> getProductsByTypeAndName(String type, String name);

	List<ProductDto> getProductsByType(String type);
}
