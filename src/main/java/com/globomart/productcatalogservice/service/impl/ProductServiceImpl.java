package com.globomart.productcatalogservice.service.impl;

import java.util.List;

import com.globomart.productcatalogservice.dao.IProductDao;
import com.globomart.productcatalogservice.dto.ProductDto;
import com.globomart.productcatalogservice.service.IProductService;

public class ProductServiceImpl implements IProductService{
	private final IProductDao productDao;

	public ProductServiceImpl(IProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public void addProduct(ProductDto productVo) {
		final ProductDto ProductDto = new ProductDto();
		ProductDto.setName(productVo.getName());
		ProductDto.setCategory(productVo.getCategory());
		productDao.save(ProductDto);
	}

	@Override
	public List<ProductDto> getProducts() {
		return productDao.findAll();
	}

	@Override
	public void deleteProduct(Long id) {
		productDao.delete(id);
	}

	@Override
	public List<ProductDto> getProductsByTypeAndName(String type, String name) {
		return productDao.findByTypeAndName(type, name);
	}

	@Override
	public List<ProductDto> getProductsByType(String type) {
		return productDao.findByType(type);
	}
}
