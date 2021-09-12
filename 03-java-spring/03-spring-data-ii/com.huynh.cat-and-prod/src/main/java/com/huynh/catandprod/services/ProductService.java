package com.huynh.catandprod.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huynh.catandprod.models.Category;
import com.huynh.catandprod.models.Product;
import com.huynh.catandprod.respositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	
	private ProductRepository pRepo;
	
	public List<Product> findAllProducts(){
		return this.pRepo.findAll();
	}
	
	public Product getOneProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Product createOneProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public List<Product> findProductNotCategory(Category category){
		return this.pRepo.findByCatsNotContains(category);
	}
	
	public void addCatToProduct(Category category, Product product) {
		List<Category> existingCat = product.getCats();
		existingCat.add(category);
		this.pRepo.save(product);
	}
	
}
