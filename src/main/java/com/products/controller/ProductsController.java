package com.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.customexception.BrandNotFoundException;
import com.products.customexception.HsnException;
import com.products.customexception.RatingException;
import com.products.entity.Product;
import com.products.service.ProductsService;

@RestController
@RequestMapping("/product")
public class ProductsController {
	@Autowired
	ProductsService ps;

	@PostMapping(value = "/setProduct")
	public String setProduct(@RequestBody Product product) {
		return ps.setProduct(product);
	}
	@PostMapping(value="/setAllProduct")
	public String setAllProduct(@RequestBody List<Product> products) {
		return ps.setAllProduct(products);
	}
	@GetMapping(value="/getAllProduct")
	public List<Product> getAllProduct() {
		return ps.getAllProduct();
	}
	@GetMapping(value="/getById/{x}")
	public Product getById(@PathVariable int x) {
		return ps.getById(x);
	}
	@GetMapping(value="/getMax")
	public List<Product> getMax() {
		return ps.getMax();
	}
	@GetMapping(value="/getMin")
	public List<Product> getMin() {
		return ps.getMin();
	}
	@GetMapping(value="/getByBrand/{x}")
	public List<Product> getByBrand(@PathVariable String x) throws BrandNotFoundException {
		return ps.getByBrand(x);
	}
	@GetMapping(value="/getByRating/{x}")
	public List<Product> getByRating(@PathVariable float x) throws RatingException {
		return ps.getByRating(x);
	}
	@GetMapping(value="/getByHsns/{x}")
	public List<Product> getByHsns(@PathVariable int x) {
		return ps.getByHsns(x);
	}
	@GetMapping(value="/getByHsn/{x}")
	public List<String> getByHsn(@PathVariable int x) throws HsnException {
		return ps.getByHsn(x);
	}
	@GetMapping(value="/getString")
	public String getString() {
		return "Hello World";
	}
	@PutMapping("/update/{x}")
	public String update(@PathVariable int x,@RequestBody Product b) {
		return ps.update(x,b);
}
}
