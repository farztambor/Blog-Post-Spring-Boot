package com.farz.blogpost.services.imp;

import com.farz.blogpost.domain.entities.Category;
import com.farz.blogpost.repositories.CategoryRepository;
import com.farz.blogpost.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }
}
