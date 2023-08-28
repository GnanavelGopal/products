package com.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.products.entity.Product;

public interface ProductsRepository extends JpaRepository<Product, Integer>{
@Query(value="select * from prod_details order by price desc limit 1",nativeQuery=true)
List<Product> getMax();
@Query(value="select * from prod_details order by price limit 1",nativeQuery=true)
List<Product> getMin();
@Query(value="select * from prod_details where brand like ?",nativeQuery=true)
List<Product> getByBrand(String x);
@Query(value="select * from prod_details where rating like ?",nativeQuery=true)
List<Product> getByRating(float x);
@Query(value="select * from prod_details where hsn like ?",nativeQuery=true)
List<Product> getByHsns(int x);
}
