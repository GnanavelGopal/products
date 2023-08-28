package com.products.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.products.entity.Product;
import com.products.repository.ProductsRepository;

@Repository
public class ProductsDao {
@Autowired
ProductsRepository pr;

public String setProduct(Product product) {
	pr.save(product);
	return "save";
}

public String setAllProduct(List<Product> products) {
	pr.saveAll(products);
	return "save all";
}

public List<Product> getAllProduct() {
	return pr.findAll();
}

public Product getById(int x) {
	return pr.findById(x).get();
}

public List<Product> getMax() {
	return pr.getMax();
}

public List<Product> getMin() {
	return pr.getMin();
}

public List<Product> getByBrand(String x) {
	return pr.getByBrand(x);
}

public List<Product> getByRating(float x) {
	return pr.getByRating(x);
}

public List<Product> getByHsns(int x) {
	return pr.getByHsns(x);
}

}
