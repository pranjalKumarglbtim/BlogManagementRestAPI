package com.blogapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapi.model.entity.Category;
import com.blogapi.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }
    @Override
    public Category updateCategory(Category category, Long id) {

        Category existingCategory = categoryRepository.findById(id).get();

        existingCategory.setTitle(category.getTitle());
        existingCategory.setDescription(category.getDescription());

        return categoryRepository.save(existingCategory);
    }
    @Override
    public void deleteCategory(Long id) {

        Category category = categoryRepository.findById(id).get();

        categoryRepository.delete(category);
    }
}