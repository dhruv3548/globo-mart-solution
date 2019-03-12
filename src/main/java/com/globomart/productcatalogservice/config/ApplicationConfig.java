package com.globomart.productcatalogservice.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.globomart.productcatalogservice.controller.ProductController;
import com.globomart.productcatalogservice.dao.IProductDao;
import com.globomart.productcatalogservice.dao.impl.ProductDaoImpl;
import com.globomart.productcatalogservice.service.IProductService;
import com.globomart.productcatalogservice.service.impl.ProductServiceImpl;

@Configuration
public class ApplicationConfig {
	@Bean
    public IProductService productService(final IProductDao IProductDao) {
        return new ProductServiceImpl(IProductDao);
    }

    @Bean
    public ProductController productController(final IProductService productService) {
        return new ProductController(productService);
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase embeddedDatabase = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2)
                .addScript("create-db.sql").addScript("insert-data.sql").build();
        return embeddedDatabase;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public IProductDao productDao(final JdbcTemplate jdbcTemplate) {
        return new ProductDaoImpl(jdbcTemplate);
    }
}
