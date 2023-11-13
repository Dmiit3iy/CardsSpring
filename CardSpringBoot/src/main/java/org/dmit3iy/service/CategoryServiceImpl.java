package org.dmit3iy.service;

import org.dmit3iy.model.Category;
import org.dmit3iy.model.User;
import org.dmit3iy.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void add(long userId, Category category) {
        User user = userService.get(userId);
        category.setUser(user);
        try {
            this.categoryRepository.save(category);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("This category has already added!");
        }
    }

    @Override
    public List<Category> get() {
        return categoryRepository.findAll();
    }

//    @Override
//    public List<Category> getByUser(long idUser) {
//        return this.get().stream().filter(x -> x.getUser().getId() == idUser)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<Category> getByUser(long idUser) {
        return this.categoryRepository.findAllByUserId(idUser);
    }



    @Override
    public Category get(long id) {
        return this.categoryRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("This Category does not exists!"));
    }

    @Override
    public Category update(Category category) {
        Category base = this.get(category.getId());
        base.setName(category.getName());
        try {
            this.categoryRepository.save(base);
            return base;
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("This category is already exists!");
        }
    }

    @Override
    public Category delete(long id) {
        Category category = this.get(id);
        categoryRepository.deleteById(id);
        return category;
    }
}
