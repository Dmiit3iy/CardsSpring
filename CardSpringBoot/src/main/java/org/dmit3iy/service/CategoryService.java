package org.dmit3iy.service;



import org.dmit3iy.model.Category;

import java.util.List;

public interface CategoryService {
    void add(long userId,Category category);
    List<Category> get();
    List<Category> getByUser(long idUser);
    Category get(long id);
    Category update(Category category);
    Category delete(long id);
}
