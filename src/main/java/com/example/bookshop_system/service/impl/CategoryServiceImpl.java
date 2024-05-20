package com.example.bookshop_system.service.impl;

import com.example.bookshop_system.entity.Author;
import com.example.bookshop_system.entity.Category;
import com.example.bookshop_system.repository.CategoryRepository;
import com.example.bookshop_system.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private static final String TEXT_FILE = "src/main/resources/files/categories.txt";

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void seedCategories() throws IOException {
        if(categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(TEXT_FILE)).stream()
                .filter(line -> !line.isEmpty())
                .forEach(categoryName -> {
                    Category category = new Category(categoryName);
                    categoryRepository.save(category);
                });
    }

    @Override
    public Set<Category> getRandomCategories(){
        Random random = new Random();
        Set<Category> categories = new HashSet<>();
        for (int i =1; i < random.ints(1, 10).findFirst().getAsInt();
        i++ ){
            Category category = categoryRepository.getById(random.longs(1,categoryRepository.count()).findFirst().getAsLong());
//                    categories.add(category);
       }
        return categories;
    }

//    public Category getRandomCategory() {
//        Random random = new Random();
//        return categoryRepository.getById(random.longs(1, 8)
//                .findFirst().getAsLong());

}
