package com.products.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.customexception.BrandNotFoundException;
import com.products.customexception.HsnException;
import com.products.customexception.RatingException;
import com.products.dao.ProductsDao;
import com.products.entity.Product;

@Service
public class ProductsService {
	@Autowired
	ProductsDao pd;

	public String setProduct(Product product) {
		return pd.setProduct(product);
	}

	public String setAllProduct(List<Product> products) {
		return pd.setAllProduct(products);
	}

	public List<Product> getAllProduct() {
		return pd.getAllProduct();
	}

	public Product getById(int x) {
		return pd.getById(x);
	}

	public List<Product> getMax() {
		return pd.getMax();
	}

	public List<Product> getMin() {
		return pd.getMin();
	}

	public List<Product> getByBrand(String x) throws BrandNotFoundException {
		List<Product> m = pd.getByBrand(x);
		if (m.isEmpty()) {
			throw new BrandNotFoundException("data is not here");
		} else {
			return m;
		}
	}

	public List<Product> getByRating(float x) throws RatingException {
		List<Product> m = pd.getByRating(x);
		if (m.isEmpty()) {
			throw new RatingException("Above rating");
		} else {
			return m;
		}
	}

	public List<Product> getByHsns(int x) {
		return pd.getByHsns(x);
	}

	public List<String> getByHsn(int x) throws HsnException {
		List<Product> m = getByHsns(x);
		List<Product> s = m.stream().filter(n -> n.getHsn() <= 120 && n.getHsn() > 110).collect(Collectors.toList());
		List<String> p = s.stream().map(y -> y.getBrand()).collect(Collectors.toList());
		if (p.isEmpty()) {
			throw new HsnException("Invalid Hsn");
		} else {
			return p;
		}
	}
	public String update(int x, Product b) {
		Product m=getById(x);
		Product n=b;
		m.setId(x);
		m.setHsn(n.getHsn());
		return setProduct(m);
}
}
