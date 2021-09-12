package com.huynh.catandprod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.catandprod.models.Category;
import com.huynh.catandprod.models.Product;
import com.huynh.catandprod.respositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	
	private CategoryRepository cRepo;
	
	public List<Category> findAllCategories(){
		return this.cRepo.findAll();
	}
	
	public Category findOneCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public Category createOneCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public List<Category> findCatNotProduct(Product product){
		return this.cRepo.findByProductsNotContains(product);
	}
	
	
	public void addProductToCategory(Product product, Category category) {
		List<Product> existingProducts = category.getProducts();
		existingProducts.add(product);
		this.cRepo.save(category);
	}
}
