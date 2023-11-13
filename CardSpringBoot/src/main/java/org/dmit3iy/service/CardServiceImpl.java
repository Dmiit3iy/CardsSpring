package org.dmit3iy.service;

import org.dmit3iy.model.Card;
import org.dmit3iy.model.Category;
import org.dmit3iy.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {
    private CardRepository cardRepository;

    @Autowired
    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void add(long idCategory, Card card) {
        Category category = this.categoryService.get(idCategory);
        card.setCreationDate(LocalDate.now());
        card.setCategory(category);
        try {
            this.cardRepository.save(card);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Card has already added!");
        }
    }

    @Override
    public List<Card> get() {
        return this.cardRepository.findAll();
    }

    @Override
    public Card get(long id) {
        return this.cardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("This Card does not exists!"));
    }

//    @Override
//    public List<Card> getByIdCategory(long id) {
//        return this.get().stream().filter(x->x.getCategory().getId()==id).collect(Collectors.toList());
//    }

    @Override
    public List<Card> getByIdCategory(long id) {
        return this.cardRepository.findAllByCategoryId(id);
    }

//    @Override
//    public List<Card> getByIdUser(long id) {
//        return this.get().stream().filter(x -> x.getCategory().getUser().getId() == id).collect(Collectors.toList());
//    }

    @Override
    public List<Card> getByIdUser(long id) {
        return this.cardRepository.findAllByCategoryUserId(id);
    }


    @Override
    public Card update(Card card) {
        Card base = this.get(card.getId());
        base.setAnswer(card.getAnswer());
        base.setQuestion(card.getQuestion());
        try {
            this.cardRepository.save(base);
            return card;
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("This card is already exists!");
        }
    }

    @Override
    public Card delete(long id) {
        Card card = this.get(id);
        cardRepository.deleteById(id);
        return card;
    }
}
