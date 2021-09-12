package com.huynh.catandprod.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huynh.catandprod.models.Category;
import com.huynh.catandprod.models.Product;
import com.huynh.catandprod.services.CategoryService;
import com.huynh.catandprod.services.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private CategoryService cService;
	
	
	//home page
	@GetMapping("/")
	public String home() {
		return "home.jsp";
	}

	//@@@ PRODUCTS @@@
	
	//all products page
	@GetMapping("/products")
	public String products(Model model) {
		List<Product> products = this.pService.findAllProducts();
		model.addAttribute("products", products);
		return "products.jsp";
	}
	
	//create product
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("price") Double price) {
		Product product = new Product(name,description,price);
		this.pService.createOneProduct(product);
		return "redirect:/products";
	}
	
	//One Product
	@GetMapping("/product/{id}")
	public String oneProduct(@PathVariable("id") Long id, Model model) {
		Product product = this.pService.getOneProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("notInProducts", this.cService.findCatNotProduct(product));
		return "product.jsp";
	}
	
	//add Cat to product

	@PostMapping("/addCategoryToProduct/{id}")
	public String addCategoryToProduct(@PathVariable("id") Long id, @RequestParam("category") Long catId) {
		Product oneProduct = this.pService.getOneProduct(id);
		Category oneCategory = this.cService.findOneCategory(catId);
		this.pService.addCatToProduct(oneCategory, oneProduct);
		return "redirect:/product/{id}";
	}
	
	//@@@@ CATEGORIES
	@GetMapping("/categories")
	public String categories(Model model) {
		model.addAttribute("categories", this.cService.findAllCategories());
		return "categories.jsp";
	}
	
	@GetMapping("/category/{id}")
	public String category(@PathVariable("id") Long id, Model model) {
		Category oneCategory = this.cService.findOneCategory(id);
		model.addAttribute("category", oneCategory);
		model.addAttribute("notInCategories", this.pService.findProductNotCategory(oneCategory));
		return "category.jsp";
	}
	
	@PostMapping("/addCategory")
	public String addCategory(@RequestParam("category") String category) {
		Category newCategory = new Category(category);
		this.cService.createOneCategory(newCategory);
		return "redirect:/categories";
	}
	
	@PostMapping("/addProductToCategory/{id}")
	public String addProductToCategory(@RequestParam("product") Long productID, @PathVariable("id") Long id) {
		Product product = this.pService.getOneProduct(productID);
		Category category = this.cService.findOneCategory(id);
		this.cService.addProductToCategory(product, category);
		return "redirect:/category/{id}";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
