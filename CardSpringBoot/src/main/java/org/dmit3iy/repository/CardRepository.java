package org.dmit3iy.repository;

import org.dmit3iy.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card,Long> {

    List<Card> findAllByCategoryId(long id);

    List<Card> findAllByCategoryUserId(long id);
}
