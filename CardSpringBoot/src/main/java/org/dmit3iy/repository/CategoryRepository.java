package org.dmit3iy.repository;

import org.dmit3iy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAllByUserId(long userId);
}
