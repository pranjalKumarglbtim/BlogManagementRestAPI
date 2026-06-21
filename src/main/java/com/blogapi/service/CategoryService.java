package com.blogapi.service;

import java.util.List;
import com.blogapi.model.entity.Category;

public interface CategoryService {

    Category createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category updateCategory(Category category, Long id);

    void deleteCategory(Long id);
}