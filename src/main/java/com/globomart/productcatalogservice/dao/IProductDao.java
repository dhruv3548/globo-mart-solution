package com.globomart.productcatalogservice.dao;

import java.util.List;

import com.globomart.productcatalogservice.dto.ProductDto;

public interface IProductDao {
	List<ProductDto> findByTypeAndName(String type, String name);

    List<ProductDto> findByType(String type);

    List<ProductDto> findAll();

    void delete(long id);

    void save(ProductDto ProductDto);
}
