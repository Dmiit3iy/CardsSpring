package org.dmit3iy.controllers;

import org.dmit3iy.dto.ResponseResult;
import org.dmit3iy.model.Category;
import org.dmit3iy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/{userId}")
    public ResponseEntity<ResponseResult<Category>> add(@PathVariable long userId,
                                                        @RequestBody Category category) {
        try {
            this.categoryService.add(userId, category);
            return new ResponseEntity<>(new ResponseResult<>(null, category), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ResponseResult<Category>> get(@PathVariable long id) {
        try {
            Category category = this.categoryService.get(id);
            return new ResponseEntity<>(new ResponseResult<>(null, category), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/user/{idUser}")
    public ResponseEntity<ResponseResult<List<Category>>> getByUser(@PathVariable long idUser) {
        try {
            List<Category> categories = categoryService.getByUser(idUser);
            return new ResponseEntity<>(new ResponseResult<>(null, categories), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseResult<List<Category>>> get() {
        List<Category> categories = this.categoryService.get();
        return new ResponseEntity<>(new ResponseResult<>(null, categories), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ResponseResult<Category>> put(@RequestBody Category category) {
        try {
            Category updateCategory = this.categoryService.update(category);
            return new ResponseEntity<>(new ResponseResult<>(null, updateCategory), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null),
                    HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult<Category>> delete(@PathVariable long id) {
        try {
            Category category = this.categoryService.delete(id);
            return new ResponseEntity<>(new ResponseResult<>(null, category), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(new ResponseResult<>(e.getMessage(), null), HttpStatus.BAD_REQUEST);
        }
    }

}
