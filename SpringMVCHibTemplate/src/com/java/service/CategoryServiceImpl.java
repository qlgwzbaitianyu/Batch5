package com.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.bean.Category;
import com.java.bean.Product;
import com.java.repository.CategoeryRepository;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoeryRepository categoryRepository;
	
	@Override
	public List<Category> findAllCategory() {
		return categoryRepository.findAllCategory();
	}

	@Override
	public List<Product> findAllProduct(String first, String max) {
		return categoryRepository.findAllProduct(first, max);
	}

	@Override
	public Product findProductById(String productId) {
		return categoryRepository.findProductById(productId);
	}

	@Override
	public Category findCategoryById(String categoryId) {
		return categoryRepository.findCategoryById(categoryId);
	}

	@Override
	public Product findProductByName(String productName) {
		return categoryRepository.findProductByName(productName);
	}

	@Override
	public long findProductCount() {
		return categoryRepository.findProductCount();
	}

	
	
}
