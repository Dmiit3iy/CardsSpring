package org.dmit3iy.service;

import org.dmit3iy.model.Card;
import org.dmit3iy.model.Category;

import java.util.List;

public interface CardService {
    void add(long idCategory, Card card);
    List<Card> get();
    Card get(long id);

    List <Card> getByIdCategory(long id);
    List <Card> getByIdUser(long id);
    Card update (Card card);
    Card delete (long id);
}
