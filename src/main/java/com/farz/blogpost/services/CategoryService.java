package com.farz.blogpost.services;


import com.farz.blogpost.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> listCategories();
    Category createCategory(Category category);
}
