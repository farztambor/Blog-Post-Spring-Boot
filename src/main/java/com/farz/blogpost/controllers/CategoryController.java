package com.farz.blogpost.controllers;

import com.farz.blogpost.domain.dtos.CategoryDto;
import com.farz.blogpost.domain.dtos.CreateCategoryRequest;
import com.farz.blogpost.domain.entities.Category;
import com.farz.blogpost.mappers.CategoryMapper;
import com.farz.blogpost.services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories() {
        List<CategoryDto> categories = categoryService.listCategories()
                .stream().map(categoryMapper::toDto)
                .toList();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        Category categoryCreated =  categoryMapper.toEntity(createCategoryRequest);
        Category saveCategory =  categoryService.createCategory(categoryCreated);

        return  new ResponseEntity<>(
                categoryMapper.toDto(saveCategory),
             HttpStatus.CREATED
        );
    }
}
