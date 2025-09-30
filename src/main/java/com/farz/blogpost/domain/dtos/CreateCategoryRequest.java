package com.farz.blogpost.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest {


    @NotBlank(message = "Category name is require")
    @Size(min = 2, max = 50, message = "Category names must be between {min} and {max} characters")
    @Pattern(regexp = "^[\\ww\\s-]+$", message = "Category name can only contain letters, numbers, spaces, and hypens")
    private String name;


}
