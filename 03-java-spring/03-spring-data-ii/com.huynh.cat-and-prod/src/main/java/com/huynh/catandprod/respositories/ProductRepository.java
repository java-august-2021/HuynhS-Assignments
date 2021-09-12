package com.huynh.catandprod.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huynh.catandprod.models.Category;
import com.huynh.catandprod.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long>{
	List<Product> findAll();
	
	List<Product> findByCatsNotContains(Category category);
}
