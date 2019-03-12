package com.globomart.productcatalogservice.dto;

public class ProductDto {
	private Long id;

	private String name;

	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String type) {
		this.category = type;
	}

	@Override
	public String toString() {
		return "ProductVo{" + "id=" + id + ", name='" + name + '\'' + ", Category='" + category + '\'' + '}';
	}
}
